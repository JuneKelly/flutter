(ns flutter.routes.entries
  (:use compojure.core)
  (:require [flutter.views.layout :as layout]
            [noir.session :as session]
            [noir.response :as response]
            [noir.validation :as vali]
            [flutter.models.db :as db]
            [flutter.helpers.auth :as auth]))


(defn feed []
  (if auth/logged-in?
    (layout/render
      "feed.html"
      {:entries (db/get-top-twenty)})
    (response/redirect "/")))


(defn create-entry [content]
  (if (auth/logged-in?)
    (do
      (db/create-user (auth/current-user) content)
      (response/redirect "/feed"))
    (response/redirect "/")))


(defn user-entries [user-id]
  (layout/render
    "user_entries.html"
    {:entries (db/get-latest-entries-for-user user-id)}))


(defroutes entry-routes
  (GET "/feed" [] (feed)))

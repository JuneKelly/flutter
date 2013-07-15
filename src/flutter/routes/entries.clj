(ns flutter.routes.entries
  (:use compojure.core)
  (:require [flutter.views.layout :as layout]
            [noir.session :as session]
            [noir.response :as resp]
            [noir.validation :as vali]
            [flutter.models.db :as db]))


(defn feed []
  (layout/render
    "feed.html"
    {:entries (db/get-top-twenty)}))


(defn user-entries [user-id]
  (layout/render
    "user_entries.html"
    {:entries (db/get-latest-entries-for-user user-id)}))


(defroutes entry-routes
  (GET "/feed" [] (feed)))

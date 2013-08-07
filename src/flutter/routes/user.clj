(ns flutter.routes.user
  (:use compojure.core)
  (:require [flutter.views.layout :as layout]
            [noir.session :as session]
            [noir.response :as response]
            [noir.validation :as vali]
            [flutter.models.db :as db]
            [flutter.helpers.auth :as auth]))


(defn all-users []
  (if auth/logged-in?
    (layout/render
      "users.html"
      {:users (db/get-all-users)})
    (response/redirect)))


(defroutes user-routes
  (GET "/users" []
       (all-users)))

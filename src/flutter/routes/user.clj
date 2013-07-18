(ns flutter.routes.user
  (:use compojure.core)
  (:require [flutter.views.layout :as layout]
            [noir.session :as session]
            [noir.response :as response]
            [noir.validation :as vali]
            [flutter.models.db :as db]))


(defn all-users []
  (layout/render
    "users.html"
    {:users (db/get-all-users)}))


(defroutes user-routes
  (GET "/users" []
       (all-users)))

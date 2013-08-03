(ns flutter.spec-util
  (:require [flutter.models.db :as db]
            [flutter.env :as env]
            [monger.core :as mg]
            [monger.collection :as mc]
            [monger.query :as mq]
            [monger.db :as md]
            [noir.util.crypt :as crypt])
  (:import [org.bson.types ObjectId]))


;; Database helpers
(mg/connect!)
(mg/set-db! (mg/get-db env/database))


(defn drop-database! []
  (md/drop-db (mg/get-db env/database)))


(defn populate-users []
  (mc/insert "users" {:_id "userone",
                      :password (crypt/encrypt "password")})
  (mc/insert "users" {:_id "usertwo",
                      :password (crypt/encrypt "password")}))

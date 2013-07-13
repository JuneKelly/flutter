(ns flutter.models.db
  (:require [flutter.models.schema :as schema])
  (:require [monger.core :as mg])
  (:require [monger.collection :as mc])
  (:import [org.bson.types ObjectId]
           [com.mongodb DB WriteConcern]))


(mg/connect!)
(mg/set-db! (mg/get-db "flutter_dev"))


(defn create-user [id, pass]
  (let [doc {:_id id, :password pass}]
    (mc/insert "users" doc)))


(defn update-user [id f-name l-name email]
  (mc/update-by-id "users" id
    {:$set {:f_name f-name,
            :l_name l-name,
            :email email}}))


(defn get-user [id]
  (mc/find-map-by-id "users" id))

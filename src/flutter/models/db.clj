(ns flutter.models.db
  (:require [flutter.models.schema :as schema])
  (:use [flutter.env :only [config]])
  (:require [monger.core :as mg])
  (:require [monger.collection :as mc])
  (:import [org.bson.types ObjectId]
           [com.mongodb DB WriteConcern]))


(mg/connect!)
(mg/set-db! (mg/get-db (:database config)))


;; Users
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


;; Entries
(defn create-entry [user-id, content]
  (let [doc {:_id (ObjectId.),
             :author user-id,
             :content content,
             :created (new java.util.Date)}]
    (mc/insert "entries" doc)))

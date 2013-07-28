(ns flutter.models.schema
  (:require [noir.io :as io]
            [monger.core :as mg]
            [monger.collection :as mc])
  (:use [flutter.env :only [get-config]]))


(mg/connect!)
(mg/set-db! (mg/get-db (:database (get-config))))


(defn initialize []
  (mc/ensure-index "users"
                   {:l_name 1})
  (mc/ensure-index "entries"
                   {:author 1})
  (mc/ensure-index "entries"
                   {:created -1}))

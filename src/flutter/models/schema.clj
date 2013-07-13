(ns flutter.models.schema
  (:require [noir.io :as io]
            [monger.core :as mg]
            [monger.collection :as mc]))


(mg/connect!)
(mg/set-db! (mg/get-db "flutter_dev"))


(defn initialize []
  (mc/ensure-index "users"
                   {:l_name 1}))

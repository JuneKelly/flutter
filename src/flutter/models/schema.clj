(ns flutter.models.schema
  (:require [noir.io :as io]
            [monger.core :as mg]
            [monger.collection :as mc]
            [flutter.env :as env]))


(mg/connect!)
(mg/set-db! (mg/get-db env/database))


(defn initialize []
  (mc/ensure-index "users"
                   {:l_name 1})
  (mc/ensure-index "entries"
                   {:author 1})
  (mc/ensure-index "entries"
                   {:created -1}))

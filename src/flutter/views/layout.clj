(ns flutter.views.layout
  (:use noir.request)
  (:require [clabango.parser :as parser]
            [noir.session :as session]))

(def template-path "flutter/views/templates/")

(defn render [template & [params]]
  (parser/render-file (str template-path template)
                      (assoc (or params {})
                        :context (:context *request*)
                        :user-id (session/get :user-id))))

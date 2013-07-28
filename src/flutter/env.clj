(ns flutter.env
  (:use [clojure.java.io]))

(def config (delay (load-file (.getFile (resource "config.clj")))))

(defn get-config []
  @(force config))

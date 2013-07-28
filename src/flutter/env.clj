(ns flutter.env
  (:use [clojure.java.io]))


(def config (delay (load-file (.getFile (resource "config.clj")))))


(defn get-config []
  @(force config))


(def host
  (:host (get-config)))


(def database
  (:database (get-config)))

(def mongo-host
  (:mongo-host (get-config)))

(ns flutter.test.handler
  (:use [clojure.test]
        [ring.mock.request]
        [flutter.handler]
        [speclj.core]
        [flutter.env :only [config]])
  (:require [clj-webdriver.taxi :as t]))

(deftest test-app
  (testing "main route"
    (let [driver (t/set-driver! {:browser :firefox} (:host config))]
      (is (= (t/text {:tag :a, :class "brand"})
             "flutter"))
      (t/quit)))

  (testing "not-found route"
    (let [response (app (request :get "/invalid"))]
      (is (= (:status response) 404)))))

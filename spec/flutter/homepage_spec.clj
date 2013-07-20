(ns flutter.homepage-spec
  (:use [speclj.core]
        [clojure.test]
        [ring.mock.request]
        [flutter.handler]
        [flutter.env :only [config]])
  (:require [clj-webdriver.taxi :as t]))


(describe "homepage"

  (it "should have flutter name in brand"
      (t/with-driver {:browser :firefox}
        (t/to (:host config))
        (should-contain "flutter" (t/text {:tag :body})))))

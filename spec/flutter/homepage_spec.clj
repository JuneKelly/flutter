(ns flutter.homepage-spec
  (:use [speclj.core]
        [clojure.test]
        [ring.mock.request]
        [flutter.handler]
        [flutter.env :only [config]])
  (:require [clj-webdriver.taxi :as t]))

(def site-root (:host config))

(describe "homepage"

  (it "should have flutter name in brand"
      (t/with-driver {:browser :firefox}
        (t/to site-root)
        (should-contain "flutter" (t/text {:tag :a, :class "brand"}))))

  (it "should have a welcome message on the page"
      (t/with-driver {:broser :firefox}
        (t/to site-root)
        (should-contain "Welcome to flutter" (t/text {:tag :body})))))

(ns flutter.homepage-spec
  (:use [speclj.core]
        [clojure.test]
        [ring.mock.request]
        [flutter.handler]
        [flutter.env :only [config]])
  (:require [clj-webdriver.taxi :as t]))

(def site-root (:host config))


(describe "homepage"

  (before-all (t/set-driver! {:browser :firefox}))
  (after-all (t/quit))

  (it "should have flutter name in brand"
      (t/to site-root)
      (should-contain "flutter" (t/text {:tag :a, :class "brand"})))

  (it "should have a welcome message on the page"
      (t/to site-root)
      (should-contain "Welcome to flutter" (t/text {:tag :body}))))

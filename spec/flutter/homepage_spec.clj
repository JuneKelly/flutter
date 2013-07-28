(ns flutter.homepage-spec
  (:use [speclj.core]
        [clojure.test]
        [ring.mock.request]
        [flutter.handler]
        [flutter.env :only [get-config]])
  (:require [clj-webdriver.taxi :as t]))

(def site-root (:host (get-config)))


(describe "homepage, with guest user"

  (before-all (t/set-driver! {:browser :firefox}))
  (after-all (t/quit))

  (before (t/to site-root))

  (it "should have flutter name in brand link"
      (should-contain "flutter" (t/text {:tag :a, :class "brand"})))

  (it "should have a welcome message somewhere on the page"
      (should-contain "Welcome to flutter" (t/text {:tag :body})))

  (it "should have a login button visible"
      (t/exists? "input.btn[value=Login]"))

  (it "should have a register link visible"
      (t/exists? "a[href='/register']")))

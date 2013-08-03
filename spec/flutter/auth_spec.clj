(ns flutter.auth-spec
  (:use [speclj.core]
        [clojure.test]
        [ring.mock.request]
        [flutter.handler])
  (:require [clj-webdriver.taxi :as t]
            [flutter.env :as env]))

(def site-root env/host)

(describe "login from homepage"

  (before-all (t/set-driver! {:browser :firefox}))
  (after-all (t/quit))

  (it "should have a login button visible"
      (t/exists? "input.btn[value=Login]"))

  (it "should have a register link visible"
      (t/exists? "a[href='/register']")))

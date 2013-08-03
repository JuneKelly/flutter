(ns flutter.auth-spec
  (:use [speclj.core]
        [clojure.test]
        [ring.mock.request]
        [flutter.handler])
  (:require [clj-webdriver.taxi :as t]
            [flutter.env :as env]
            [flutter.spec-util :as util]))


(def site-root env/host)


(describe "login form on homepage"

  (before-all (t/set-driver! {:browser :firefox}))
  (after-all (t/quit))

  (it "should have a login button visible"
      (t/exists? "input.btn[value=Login]"))

  (it "should have a register link visible"
      (t/exists? "a[href='/register']")))


(describe "login as existing user"

  (before-all (t/set-driver! {:browser :firefox}))
  (after-all (t/quit))

  (before (util/drop-database!)
          (util/populate-users))

  (it "should allow a user to log in"
      (t/to site-root)
      (t/quick-fill-submit {"#id" "userone"}
                           {"#pass" "password"}
                           {"input.btn[value=Login]" t/click})
      (should-contain "userone" (t/text {:tag :body}))
      (should-contain "Users" (t/text {:tag :body}))
      (should-contain "Feed" (t/text {:tag :body}))))

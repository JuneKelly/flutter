(ns flutter.homepage-spec
  (:use [speclj.core]
        [clojure.test]
        [ring.mock.request]
        [flutter.handler]))


(describe "homepage"
  (it "should have flutter name"
    (let [response (app (request :get "/"))]
      (should= 200 (:status response))
      (should-contain "flutter" (:body response)))))

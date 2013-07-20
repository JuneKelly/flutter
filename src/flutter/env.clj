(ns flutter.env)


(def config
  (let [env (or (System/getenv "FLUTTER_ENV") "dev")]
    ((keyword env)
      { :dev
        {
          :host "http://localhost:3000"
          :mongo_host "localhost"
          :database "flutter_dev"
        }
        :test
        {
          :mongo_host "localhost"
          :database "flutter_test"
        }
        :prod
        {
          :mongo_host ""
          :database "flutter"
        }
       })))

(ns flutter.env)


(def config
  (let [env (or (System/getenv "ENVIRONMENT") "development")]
    ((keyword env)
      { :development
        {
          :mongo_host "localhost"
          :database "flutter_dev" 
        }
        :test
        {
          :mongo_host ""
          :database "flutter_test"
        }
        :prouction
        {
          :mongo_host ""
          :database "flutter" 
        }
       })))

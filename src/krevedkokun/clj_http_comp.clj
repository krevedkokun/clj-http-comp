(ns krevedkokun.clj-http-comp
  (:require [org.httpkit.server :as httpkit]
            [com.appsflyer.donkey.core :as donkey]
            [org.httpkit.client :as http]
            [immutant.web :as immutant]
            [ring.adapter.jetty])
  (:gen-class))

(defn greet
  "Callable entry point to the application."
  [data]
  (println (str "Hello, " (or (:name data) "World") "!")))

(defn handler [req]
  {:status 200
   :body (or (:body req) "{\"message\":\"Hello\"}")})

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (greet {:name (first args)}))

(comment

(def stop-httpkit
  (httpkit/run-server handler {:port 5001
                               :thread 100}))

(stop-httpkit)


(def stop-jetty
  (ring.adapter.jetty/run-jetty handler {:port 5002
                                         :max-threads 100
                                         :join? false}))

(.stop stop-jetty)


(def stop-immutant
  (immutant/run handler {:host "0.0.0.0" :port 5003 :path "/"}))

(.stop (immutant/server {:host "0.0.0.0" :port 5003}))

(immutant/stop {:host "0.0.0.0" :port 5003})
(.stop )

@(http/get "http://localhost:5003/_perf1")

@(http/get "http://localhost:5003")

(slurp (:body @(http/get "http://localhost:5001")))

@(http/get "http://localhost:5002")






)

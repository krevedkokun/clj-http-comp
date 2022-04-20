(ns krevedkokun.clj-http-comp
  (:require [charred.api :as charred]
            [cheshire.core :as cheshire]
            [clojure.pprint :as pp]
            [com.appsflyer.donkey.core :as donkey]
            [immutant.web :as immutant]
            [jsonista.core :as jsonista]
            [org.httpkit.client :as http]
            [org.httpkit.server :as httpkit]
            [pohjavirta.server :as pohjavirta]
            [ring.adapter.jetty :as jetty])
  (:gen-class))

(defn handler
  [{:keys [body uri] :as req}]
  #_(pp/pprint req)
  (case uri
    "/_perf1"
    {:status 200
     :body (or body "{\"message\":\"Hello\"}")}

    "/cheshire"
    {:status 200
     :body (some-> body
                   (slurp)
                   (cheshire/parse-string)
                   (cheshire/generate-string))}

    "/jsonista"
    {:status 200
     :body (some-> body
                   (slurp)
                   (jsonista/read-value)
                   (jsonista/write-value-as-string))}

    "/charred"
    {:status 200
     :body (some-> body
                   (slurp)
                   (charred/read-json)
                   (charred/write-json-str))}

    {:status 404
     :body "{\"message\": \"no such route\"}"}))

(defn -main
  [& _args])

(comment

  (some-> "{\"message\":\"Hello\"}"
          (cheshire/parse-string)
          (cheshire/generate-string))

  (def stop-httpkit
    (httpkit/run-server #'handler {:port 5001
                                   :thread 100}))

  (stop-httpkit)


  (def stop-jetty
    (jetty/run-jetty #'handler {:port 5002
                                :max-threads 100
                                :join? false}))

  (.stop stop-jetty)


  (def stop-immutant
    (immutant/run #'handler {:host "0.0.0.0" :port 5003 :path "/"}))

  (.stop (immutant/server {:host "0.0.0.0" :port 5003}))

  (immutant/stop {:host "0.0.0.0" :port 5003})

  (def pohjavirta
    (pohjavirta/create #'handler {:port 5004
                                  :worker-threads 100
                                  :host "0.0.0.0"}))

  (pohjavirta/start pohjavirta)

  (pohjavirta/stop pohjavirta)

  @(http/get "http://localhost:5003/_perf1")

  @(http/get "http://localhost:5003")

  (slurp (:body @(http/get "http://localhost:5001")))

  @(http/get "http://localhost:5002")






  )

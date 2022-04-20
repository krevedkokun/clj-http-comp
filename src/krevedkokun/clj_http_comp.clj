(ns krevedkokun.clj-http-comp
  (:require [org.httpkit.server :as httpkit]
            [com.appsflyer.donkey.core :as donkey]
            [immutant.web :as immutant]
            )
  (:gen-class))

(defn greet
  "Callable entry point to the application."
  [data]
  (println (str "Hello, " (or (:name data) "World") "!")))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (greet {:name (first args)}))

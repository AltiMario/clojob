(ns clojob.scheduler
  (:require [clj-http.client :as client]
            [cheshire.core :as json])
  (:gen-class))


(defn get-jobslist
  "return the list of all jobs"
  [url usr pwd]
  (:body (client/get url
                     {:basic-auth [usr pwd]})))

(defn put-job
  "add a new scheduling with the custom Clojure job"
  [url usr pwd]
  (:body (client/post url
                      {:basic-auth [usr pwd]
                       :headers    {"Content-type" "application/json"}
                       :body (json/generate-string {:jobClass "com.carfey.ops.job.maint.MyJob",
                                                    :nickname "test-job"
                                                    :recoveryType "NONE"
                                                    :state "ENABLED"
                                                    :schedule "30 * * * *",})})))

(defn -main
  [& args]
  (get-jobslist "http://localhost:8080/obsidian/rest/jobs" "admin" "changeme")
  (put-job "http://localhost:8080/obsidian/rest/jobs" "admin" "changeme"))
(ns clojob.core
  (:gen-class))

(defn hello
  "A very simple task to run as job via Obsidian"
  [name]
  (spit "temp.txt" (str "I wrote this file for " name "\n") :append true))

(comment
  (hello "mario"))

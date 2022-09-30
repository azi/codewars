(ns code-wars
 (:require
   [java-time :as t]))

(defn now
  "Returns the current datetime"
  []
  (t/instant))

(comment
 (now))

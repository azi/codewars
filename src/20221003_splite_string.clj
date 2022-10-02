(ns code-wars
 (:require
   [clojure.string :as str]))

;; * 'abc' =>  ['ab', 'c_']
;; * 'abcdef' => ['ab', 'cd', 'ef']


(def txt "abc")
(def txt2 "abcdef")

(mapv str/join (partition 2 2 "_" txt))

(conj txt "_")

(let [txt3  (cond-> txt
                    (odd? (count txt)) (str "_"))]

    (->> (partition 2 txt3)
         (mapv (fn [items] (str/join "" items)))))

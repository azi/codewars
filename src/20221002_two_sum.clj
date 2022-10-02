(ns code-wars
 (:require))
   ;; [clojure.string :refer [index-of]]))

;; two_sum([1, 2, 3], 4) == {0, 2}

[1 2 3] = [1 2] [1 3] [2 3]

[1 2 3 4] = [1 2] [1 3] [1 4]
            [2 1] [2 3] [2 4]
            [3 1] [3 2] [3 4]


;; (def txt  [1 2 3])

(def txt (map-indexed vector [2 2 3]))

(first txt)
;; (def index-of )

(apply map vector [txt txt])
(partition 2 3 txt)
;; (.indexOf txt 3)

(def target 4)



(filter
  (fn [x]
    (let [x-index (.index-of txt x)
          y-index (.index-of txt (- 4 x))]
     (and (> x-index 0) (> y-index 0))))
  txt)

;; (loop [t       target
;;        result  []]
;;   (if (> iter 10)
;;     (println acc)
;;     (recur (inc iter) (+ acc iter))))

(-> (for [x txt
          :let [x-index (first x)
                x-val   (last  x)
                y-index (or (->> txt
                               (filter (fn [[idx v]] (and (> idx x-index) (= v (- target x-val)))))
                               first first) -1)]
          :when (and (>= x-index 0) (>= y-index 0))]
     [x-index y-index])
    first)

(map
  (fn [e]
    (map (fn [x] [e x]) [2 2 3]))
  [2 2 3])


(def digits [1 2 3])

(for [x1 (range (count [1 2 3]))
      x2 (range (count [1 2 3]))]
  [x1 x2])

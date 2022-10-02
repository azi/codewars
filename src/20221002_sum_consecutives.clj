(ns code-wars)

;; [1,4,4,4,0,4,3,3,1] # should return [1,12,0,4,6,1]

(def txt [1 4 4 4 0 4 3 3 1])

(frequencies txt)
(partition-by identity txt)
(reduce + '(1 3))


(->> txt
     (partition-by identity)
     (mapv #(reduce + %)))


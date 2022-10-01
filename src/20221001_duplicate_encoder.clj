(ns code-wars
 (:require
  [clojure.string :refer [lower-case] :as str]))

;; (def items {"din"      "((("
;;             "recede"   "()()()"
;;             "Success" ")())())"
;;             "(( @      "))(("})


;; (let [txt    (lower-case "(( @")
;;       rules  (->> "(( @"
;;                  frequencies
;;                  (map (fn [[k v]]
;;                         (let [replace-txt (cond
;;                                             (= v 1) "("
;;                                             (> v 1) ")")]
;;                          [(str k) replace-txt])))
;;                  (into {}))
;;        pattern (re-pattern (->> (set "(( @")
;;                                 (str/join "|"))

;;   (str/replace txt pattern rules))



;; (re-pattern (->> (set "CC @")
;;                  (str/join "|"))

(str/escape " |@|C" {"C" \C})

(str/replace "(( @" #" |\(|\@" {"(" ")" " " "(" "@" "("})

;; (str/escape "(( @"  {\( ")" " " \( "@" "("})

;; (str/replace "Vab3a"    #"a|3|V"       {"a" "1" "3" "2" "V" "4"})

(type (first (first (frequencies "AB"))))

(contains? (mapv str (set [\( \) \* \+ \? \[ \] \. \^ \\ \| \$])) "+")
(contains? (set [\( \) \* \+ \? \[ \] \. \^ \\ \| \$]) +)

(re-matches #"\w+" "**")
;; (re-matches #"\W+" \))
(re-matches #"[\W+]" "*a")
(re-find (re-pattern "\\W") "ab")

(defn rules
  [txt]
  (->> txt
       lower-case
       frequencies
       (map (fn [[k v]]
              (let [pattern (cond->> (str k)
                                     (re-find (re-pattern "\\W") (str k)) (str "\\"))
                                     ;;(not (re-matches #"\w+" (str k))) (str "\\"))
                                     ;; (or (= \( k) (= \) k)) (str "\\"))
                    replacement (cond
                                  (= v 1) "("
                                  (> v 1) ")")]
                [(re-pattern pattern) replacement])))
       (into {})))

(map rules ["Success*"])
(map rules ["din" "recede" "Success" "(( @"])
(map rules ["din" "recede" "Success" "(( @+"])


(re-matches #"/x/" "ab% +")

;; Best answer from code-wars
;; (defn encode-dups [text]
;;   (let [text (clojure.string/lower-case text)
;;         freq (frequencies text)]
;;     (apply str (map #(if (= (freq %) 1) \( \) ) text))))

(def dict (->> "(( @"
                lower-case
                frequencies))

(map (fn [c]
       (if (= (dict c) 1) "(" ")")) "(( @")


(reduce
  (fn [result [pattern replacement]]
    (str/replace result pattern replacement)
  )
  (lower-case "<< *")
  (rules "<< *"))

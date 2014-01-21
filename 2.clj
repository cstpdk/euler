#!/usr/bin/env clojure

;;;; Eulerproblem 2
;;;; Find the highest sum of even-valued
;;;; numbers less than four million in the fibonnaci sequence 

(defn arg-n-is-x? [n,x]
  (= x (nth *command-line-args* n)))

(def do-tests? (arg-n-is-x? 0 "1"))
(def print-result? (arg-n-is-x? 1 "1"))

(defn do-test [description expected actual]
  (println (str description (= expected actual))))

(defn tests [] (do
                (do-test "John? " false true)))

(defn result []
  (str "john"))

(if do-tests? (tests))

(if print-result? (println (result)))

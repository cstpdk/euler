#!/usr/bin/env clojure

;;;; Eulerproblem 2
;;;; Find the highest sum of even-valued
;;;; numbers less than four million in the fibonnaci sequence 

(defn arg-n-is-x? [n,x]
  (let [args *command-line-args*]
    (if (> (+ n 1) (count args))
      false
      (= x (nth args n)))))

(def do-tests? (arg-n-is-x? 0 "1"))
(def print-result? (arg-n-is-x? 1 "1"))

(defn is-even? [x]
  (= 0 (mod x 2)))

(defn x-is-larger-than-y? [x,y]
  (> x y))

;; Support for lazily evaluated sequence. Well played clojure
(defn lazy-fibs []
  ((fn fib [a,b]
    (lazy-seq (cons a (fib b (+ a b))))) 0 1))

(defn fibs-upto-x [x]
  ;; Explicit partial appliance. Not sure if loving it. When in Lisp-land, I guess
  (take-while (partial x-is-larger-than-y? x) (lazy-fibs)))

(defn do-test [description expected actual]
  (println (str description (= expected actual))))

(defn tests [] (do
                (do-test "2 is even " (is-even? 2) true)
                (do-test "3 is not even " (is-even? 3) false)
                (do-test "100 is even " (is-even? 100) true)
                (do-test "First 6 fibs are 0 1 1 2 3 5 " (take 6 (lazy-fibs)) [0 1 1 2 3 5])
                (do-test "100 is less than 101 " (x-is-larger-than-y? 101 100) true)
                (do-test "elements less than 6 is a sequence of 6 elements " (count (fibs-upto-x 6)) 6)
                 ))


(defn result []
  (reduce + (filter even? (fibs-upto-x 4000000))))

(if do-tests? (tests))

(if print-result? (println (result)))

#!/usr/bin/env clisp
;;;; Eulerproblem 1
;;;; Find all multiples of 3 or 5 below 1000

;; Command line args
(defun args()
  ext:*args*)

(defun arg-n-is-true(n)
  (when (<= n (list-length (args)))
    (= 0 (parse-integer (nth n (args))))))

;; Should we display test results? arg0
(defvar *test* (arg-n-is-true 0))

;; Should we compute the result? arg1
(defvar *run* (arg-n-is-true 1))


;;; 1) Funtion to determine if arg1 is multiple of 3 or 5
;;; 2) Compute list [0..1000]
;;; 3) Map above list of numbers to a list of numbers that satisfy 
;;;     above precondition
;;; 4) Sum above list

;; 1)
(defun multipleOf3Or5 (n)
  (or (= 0 (mod n 3))
      (= 0 (mod n 5))))

;; 2)

(defun result ()
  (multipleOf3Or5 5))

(defun test (description expected actual)
  (format t "~S: ~S ~%" description (eq expected actual)))

(when *test* T
  (progn 
    (test "3 is multiple of 3 or 5" T (multipleOf3Or5 3))
    (test "5 is multiple of 3 or 5" T (multipleOf3Or5 5))
    (test "9 is multiple of 3 or 5" T (multipleOf3Or5 9))
    (test "8 is not multiple of 3 or 5" NIL (multipleOf3Or5 8))))

(when *run* T
    (format t "~S" (result)))

;;; /* Proyecto 1 */
;;; /* conversión de grados Farenheit a centígrados */
(format t "conversión de grados Farenheit a centígrados")

;;; /* Fibonnacci */
(format t "Fibonnacci")

;; Obtenido de https://riptutorial.com/common-lisp/example/24092/compute-nth-fibonacci-number
;; Find the nth Fibonacci number for any n > 0.
;; Precondition: n > 0, n is an integer. Behavior undefined otherwise.
(defun fibonacci (n)
    (cond
        (                                     ;; Base case.
             ;; The first two Fibonacci numbers (indices 1 and 2) are 1 by definition.
            (<= n 2)                          ;; If n <= 2
            1                                 ;; then return 1.
        )
        (t                                    ;; else
            (+                                ;; return the sum of
                                              ;; the results of calling 
                (fibonacci (- n 1))           ;; fibonacci(n-1) and
                (fibonacci (- n 2))           ;; fibonacci(n-2).
                                              ;; This is the recursive case.
            )
        )
    )
)

;;; /* Factorial */
(format t "Factorial")

;; Obtenido de https://stackoverflow.com/questions/47602677/recursive-factorial-function-in-common-lisp
(defun factorial (n)
  (if (= n 1)              
      1                           
      (* n (factorial (- n 1))))
      ) 
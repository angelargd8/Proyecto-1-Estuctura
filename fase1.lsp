;;;====================
;;; || Proyecto 1 ||
;;;====================
;; practica de programas utilizando Common Lisp

;;; /* conversión de grados Farenheit a centígrados */
(format t "conversión de grados Farenheit a centígrados")

;; Se define la función fahr-cel con un parámetro con el valor a convertir de grados Farhenheit a Celsius
;;; condiciones n > 0
(defun fahr-cel (fahr)

  ;; formula para la conversión de unidades °F a °C, retornando el resultado
  (/ (- fahrenheit 32) 1.8))

;;; Ejemplo:
;; Envío: 32°F y 68° a fahr-cel
;; Retorno: 0°C y 20°C
(print (fahr-cel 32))
(print (fahr-cel 68))

;;; /* producción del termino n de la serie Fibonnacci */
(format t "Fibonnacci")

;; Se define la función para determinar la serie Fibonnacci de un valor n
;;; condiciones n > 0
(defun fibonacci (n)

	;; condicion para evaluar que n sea mayor o igual a 2, porque la serie de 1 y 2 es 1
    (cond
        (
			;; si n está entre 1-2 retornar su valor teórico 1
            (<= n 2)                          
            1                                 
        )
		;; sino realizar recursión de fibonacci de la suma de sus valores anteriores 
		;; de 1 posición y 2 posiciones antes de n hasta que n sea 2
        (t
            (+
				;; recursión enviando el primer valor antes de n 
                (fibonacci (- n 1))
				;; recursión enviando el segundo valor antes de n 
                (fibonacci (- n 2))
            )
        )
    )
)

;;; Ejemplo:
;; Envío: 8 y 9 a fibonacci
;; Retorno: 21 y 34
(print (fibonnaci 8))
(print (fibonnaci 9))


;;; /* producción del factorial de un valor n*/
(format t "Factorial")

;; Se define la función para determinar la serie el factorial de un valor n
;;; condiciones n > 0
(defun factorial (n)

	;; si n = 1 retornar su valor teórico 1
	(if (= n 1)              
      1          
		;; sino realizar recursión de factorial, multiplicando un valor n-1 hasta que n = 1
		(* n (factorial (- n 1))))
      ) 
	  
;;; Ejemplo:
;; Envío:  5 y 6 a factorial
;; Retorno: 120 y 720
(print (factorial 5))
(print (factorial 6))
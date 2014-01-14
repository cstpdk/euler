1.lisp:
	chmod u+x 1.lisp

1.run: 1.lisp
	./1.lisp 1 0
1.test: 1.lisp
	./1.lisp 0 1

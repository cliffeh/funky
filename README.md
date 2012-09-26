# funky
__a simple functional language implemented in Java__

### compiling
funky can be compiled, tested, and packaged using maven as follows (from the root project directory):

__to compile:__ `mvn compile`

__to run all available unit tests:__ `mvn test`

__to package *(generate a jar file)*:__ `mvn package`

All compiled classes/jar files will show up in ${project_root}/target.

### running
There is a simple bash script in ${project_root}/bin. Please note that this script is not all that robust at this point
and will need to be modified if you intend to run it using a jar. To use it as-is, run the following from the root
project directory: `bin/funky`

### supported expressions

Basic integer operations (add, subtract, multiply, divide) which support an arbitrary number of arguments:

* `(+ 1 2)` => 3
* `(* 6 7)` => 42
* `(* 5 (+ 3 4))` => 35
* `(+ 1 2 3 4)` => 10

Boolean operations _and_ and _or_:

* `(and #t #t)` => #t
* `(or #t #f)` => #t

Equality operator _eq_:

* `(eq 7 7)` => #t
* `(eq 7 6)` => #f
* `(eq 7 7 (+ 1 2) (+ 3 4))` => 3
* `(eq 7 6 (+ 1 2) (+ 3 4))` => 7

Variables and functions can be defined using _defvar_ and _defun_, respectively:

* `(defvar x 5)`
* `(defun double (x) (* x 2))`

String operations:

* _substr_ [examples: `(substr "Hello, world!" 7)` => "world!", `(substr "Hello, world!" 7 5)` => "world"]
* _string-length_ [example: `(string-length "Hello, world!")` => 13]
* _string-char_ [example: `(string-char "Hello, world!" 7)` => "w"]

The _let_ expression:

* `(let ((x 10) (y 20)) (+ x y))` => 30

### (currently) unsupported

There are a whole lot of things not currently supported by funky. This is a list some of the things I'd like to implement "sooner rather than later" and is by no means exhaustive:

* lambda (anonymous) functions
* more string operations
* floating-point numbers and arithmetic
* arbitrary-precision integers and floats
* basic file and socket operations (_open_, _read_, _write_)
* basic program control constructs (_if_, _while_/_for_ loops)
* list manipulation (_car_, _cdr_, _cons_)

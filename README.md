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

### expressions

Basic integer operations (add, subtract, multiply, divide) are available; e.g., :

* `(+ 1 2)`
* `(* 6 7)`
* `(* 5 (+ 3 4))`

The boolean operations _and_ and _or_ are available:

* `(and #t #t)`
* `(or #t #f)`
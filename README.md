# kotlin-for-java-devs-course
Place for my code and notes from this course: https://www.udemy.com/course/kotlin-for-java-developers/

## Kotlin versus Java differences
* Semi-colons are redundant/optional in Kotlin (but do not cause an error)
* Bracket notation can be used to get an element of a collection (example: someList[2])
* Kotlin implements its own 'string' class, that is different from Java's
  * https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/
* Kotlin does treats all exceptions as unchecked exceptions, and has no 'throws' keyword
* Kotlin does not support the Java ternary operator (x > y ? 888 : 999)
* Kotlin does not support all Java for loop types, such as for loop with index variable
* Kotlin has no 'static' keyword
* Kotlin has no 'new' keyword
* Kotlin uses triple-equals operator for reference equality
  * objA === objB (checking if references are the same)
  * objA == objB  (in Kotlin this is same as objA.equals(objB) in Java)


## Other Kotlin notes
* Kotlin variables are statically typed.
* Kotlin uses compile-time type inference. Types are determined by the context in which the variables are used.
* Keyword 'val' is equivalent of a Java 'final' variable, and 'var' is a non-final variable.
* Many Kotlin classes are just wrappers for underlying Java classes (such as StringBuilder)
* Function parameters must explicitly define a type. The type cannot be inferred.
* How to properly structure modules is not made clear in the course. Their example shows one module nested inside another. I don't know if that is a typical real world use case.
  * Module dependencies seems to be defined in the IntelliJ .iml file, and not part of the source code.

## Kotlin reference material

### Kotlin for JVM standard library reference
https://kotlinlang.org/api/latest/jvm/stdlib/

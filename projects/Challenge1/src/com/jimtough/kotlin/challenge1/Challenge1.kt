package com.jimtough.kotlin.challenge1

// NOTE: IntelliJ says the 'args' parameter to main() is no longer required since Kotlin 1.3.
//       The course material pre-dates Kotlin 1.3.
fun main(args: Array<String>) {

    val hello1 = "Hello"
    val hello2 = "Hello"
    // NOTE: We expect a result of true. This is because, like Java, the JVM will optimize internally to
    //       reuse string literals that have already been defined in the same application.
    println("Are hello1 and hello2 referentially equal? ${hello1 === hello2}")
    println("Are hello1 and hello2 structurally equal? ${hello1 == hello2}")

    // These statements both do the same thing. 'Int' is the default type for whole numbers.
    var myIntA: Int = 2988
    var myIntB = 2988

    val myAny: Any = "The Any type is the root of the Kotlin class hierarchy"
    // Use 'Smart Casting' inside the 'if is' block
    if (myAny is String) {
        println(myAny.toUpperCase())
    }

    println("""    1
        |   11
        |  111
        | 1111""".trimMargin())

}
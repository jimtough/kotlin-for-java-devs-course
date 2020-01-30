package com.jimtough.kotlin.trycatch

import java.lang.NumberFormatException
import java.lang.UnsupportedOperationException

fun main() {

    println(parseStringAndReturnInt("123"))
    println(parseStringAndReturnInt("123.45"))
    println(parseStringAndReturnInt("9999999999999999999999999999999999999"))
    println(parseStringAndReturnInt("foobar"))

    println()

    println(parseStringAndReturnIntNoCatch("456"))
    // The following line would throw an exception if uncommented
    //println(parseStringAndReturnIntNoCatch("foobar"))

    println()

    println(parseStringAndReturnIntOrNull("456"))
    // We can easily add a 'throw' inside an Elvis operator statement
    println(parseStringAndReturnIntOrNull("foobar") ?: throw IllegalArgumentException("Number string was not a valid Int"))

}

fun parseStringAndReturnInt(s: String): Int {
    return try {
        // Value of last expression in the 'try' is returned, if no exceptions are thrown
        Integer.parseInt(s)
    } catch (e: NumberFormatException) {
        // Value of last expression in the 'catch' is returned
        111 + 222
        -1
    } finally {
        println("In finally block")
        // NOTE: The value below is useless, as the 'finally' block does not affect the value return from the try/catch.
        //       It also does not cause any compilation errors, and just a warning in IntelliJ.
        1234567
    }
}

fun parseStringAndReturnIntNoCatch(s: String): Int {
    return try {
        // Value of last expression in the 'try' is returned, if no exceptions are thrown
        Integer.parseInt(s)
    } finally {
        println("In finally block")
    }
}

fun parseStringAndReturnIntOrNull(s: String): Int? {
    return try {
        // Value of last expression in the 'try' is returned, if no exceptions are thrown
        Integer.parseInt(s)
    } catch (e: Exception) {
        null
    } finally {
        println("In finally block")
    }
}

// Note the use of the 'Nothing' return type here
// Not sure why the instructor mentioned this here, because it does Nothing ;) to prevent the exception being thrown
fun myStubFunction(s: String): Nothing {
    throw UnsupportedOperationException("stub function")
}

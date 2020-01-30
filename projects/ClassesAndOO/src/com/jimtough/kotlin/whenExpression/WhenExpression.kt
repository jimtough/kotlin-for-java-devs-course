package com.jimtough.kotlin.whenExpression

import java.math.BigDecimal
import java.time.LocalDateTime
import com.jimtough.kotlin.enums.Department as DepEnum

// 'when' is the Kotlin replacement for the Java 'switch' statement

// NOTE: Kotlin 'when' does not support fallthrough like the Java switch used to. My opinion: good riddance.

fun main() {

    // trivial example
    val numA = 200
    when (numA) {
        100 -> println("was 100")
        200 -> println("was 200")
        300 -> println("was 300")
        else -> println("Doesn't match anything")
    }

    // example with two cases on the same line
    val numB = 600
    when (numB) {
        100, 600 -> println("was either 100 or 600")
        200 -> println("was 200")
        else -> println("Doesn't match anything")
    }

    // example with a range
    val numC = 42
    when (numC) {
        in 0..99 -> println("in 0 to 99 range")
        100, 600 -> println("was either 100 or 600")
        200 -> println("was 200")
        else -> println("Doesn't match anything")
    }

    // You can use an expression, unlike Java where only constant values are allowed
    val y = 10
    var numD = 70
    when (numD) {
        y + 60 -> println("was whatever 'y + 60' is: ${y + 60}")
        // Interesting! Never gets to the following case if the expression above matches.
        70 -> println("was 70")
        999 -> println("was 999")
        else -> println("Doesn't match anything")
    }

    // You can even use an 'is' expression
    val objA: Any = "I'm a string"
    val objB: Any = BigDecimal(25.2)
    val objC: Any = 42
    val objD: Any = LocalDateTime.now()
    val objArray = arrayOf(objA, objB, objC, objD)
    for (oIndex in objArray.indices) {
        val o = objArray[oIndex]
        println("Looking at object at array index $oIndex")
        when (o) {
            is String -> println("It is a string: [$o]")
            is BigDecimal -> println("It is a BigDecimal: $o")
            is Int -> println("It is an Int: $o")
            else -> println("What is this? [$o]")
        }
    }

    println("-------------------------------------------------------")

    // The 'when' is able to return values!
    for (oIndex in objArray.indices) {
        val o = objArray[oIndex]
        println("Looking at object at array index $oIndex")
        val result = when (o) {
            is String -> {
                println("It is a string: [$o]")
                12345
            }
            is BigDecimal -> {
                println("It is a BigDecimal: $o")
                "Your decimal is soooooo big!"
            }
            is Int -> {
                println("It is an Int: $o")
                arrayOf(1,2,3,4)
            }
            else -> {
                println("What is this? [$o]")
                "foobar"
            }
        }
        println("result: $result")
    }

    // 'when' supports enums, of course...
    for (e in DepEnum.values()) {
        val result = when (e) {
            DepEnum.HR -> "Goodbye Toby!"
            DepEnum.ACCT -> "Hey Angela! How's Sprinkles?"
            DepEnum.IT -> "What was that guy's name again?"
            DepEnum.SALES -> "What type of bear is best? Black bear."
            DepEnum.SEC -> "Hey Chief! We're locked in!"
            // No 'else' needed here, because every enum value has been explicitly handled above.
        }
        println(result)
    }

    // Interesting! You can use 'when' without an input value, unlike Java 'switch'.
    val a = 10
    val b = 100
    when {
        a < b -> println("a is less than b")
        a > b -> println("a is greater than b")
        else -> println("a must be equal to b!")
    }

}






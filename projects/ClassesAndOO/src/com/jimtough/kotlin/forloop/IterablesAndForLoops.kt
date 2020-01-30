package com.jimtough.kotlin.forloop

fun main() {
    // Any object that is iterable can be used in a 'for' loop with using 'in' operator
    for (s in "Hello World") {
        // do something here...
    }

    val myIntArray = arrayOf(1, 2, 3, 4)
    var sum = 0
    for (x in myIntArray) {
        sum += x
    }
    println("sum is: $sum")

    val myStringArray = arrayOf("alpha", "baker", "charlie", "delta", "echo")
    var tempStr = ""

    // Kotlin arrays provide an iterable 'indices' property that works well with 'for' loops
    for (i in myStringArray.indices) {
        println("Value '${myStringArray[i]}' is at array index $i.")
    }

    // Kotlin collection classes provide a 'forEach()' function that accepts a lambda, similar to Java.
    // Refer to the current array element as 'it' in the lambda.
    tempStr = ""
    myStringArray.forEach { tempStr += "$it " }
    println(tempStr)

    // Kotlin collection classes provide a 'forEachIndexed()' function that accepts a lambda
    tempStr = ""
    myStringArray.forEachIndexed { index,value -> tempStr += "($index|$value) " }
    println(tempStr)

}
package com.jimtough.kotlin.generics

import java.math.BigDecimal

fun main() {

    val numberList: MutableList<Number> = mutableListOf(1, 2.22, 3.333f, BigDecimal(12.345))
    val shortList: MutableList<Short> = mutableListOf(1, 2, 3)
    val doubleList: MutableList<Double> = mutableListOf(1.11, 2.22, 3.33)
    consumeMutableListOfNumbers(numberList)
    // These do not work - MutableList does not support this
    //consumeMutableListOfNumbers(shortList)
    //consumeMutableListOfNumbers(doubleList)

    // No problem! This method accepts List, which does support this (see the 'out' modifier on the generic type of List)
    consumeImmutableListOfNumbers(numberList)
    consumeImmutableListOfNumbers(shortList)
    consumeImmutableListOfNumbers(doubleList)

    // Also no problem! The explicit 'out' modifier on the function parameter (MutableList<out Number>)
    // makes this OK.
    consumeMutableListOfNumbersWithOutModifier(numberList)
    consumeMutableListOfNumbersWithOutModifier(shortList)
    consumeMutableListOfNumbersWithOutModifier(doubleList)

}

fun consumeMutableListOfNumbers(listOfNumbers: MutableList<Number>) {
    for (n in listOfNumbers) {
        println("Number is [${n.toInt()}] after converting to Int")
    }
}

fun consumeImmutableListOfNumbers(listOfNumbers: List<Number>) {
    for (n in listOfNumbers) {
        println("Number is [${n.toInt()}] after converting to Int")
    }
}

fun consumeMutableListOfNumbersWithOutModifier(listOfNumbers: MutableList<out Number>) {
    for (n in listOfNumbers) {
        println("Number is [${n.toInt()}] after converting to Int")
    }
}

// This will not compile. You cannot do a modification operation when the generic type has the 'out' modifier.
//fun addNumberToMutableListOfNumbers(listOfNumbers: MutableList<out Number>) {
//    listOfNumbers.add(42)
//}

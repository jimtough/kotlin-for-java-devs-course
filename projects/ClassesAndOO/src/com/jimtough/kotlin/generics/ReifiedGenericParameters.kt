package com.jimtough.kotlin.generics

import java.math.BigDecimal
import java.time.LocalDateTime

// Kotlin has a feature (seems more like a workaround) to deal with some type erasure limitations.
// It involves using inline functions, and the 'reified' keyword on generic types.

fun main() {

    val mixedTypeList: List<Any> = listOf("a string", 123, Any(), 43.21f, BigDecimal(12.345), LocalDateTime.now())
    val onlyNumbersList: List<Number> = getElementsOfType(mixedTypeList)
    println("onlyNumbersList: $onlyNumbersList")
    val onlyStringsList: List<String> = getElementsOfType(mixedTypeList)
    println("onlyStringsList: $onlyStringsList")
    val onlyBigDecimalsList: List<BigDecimal> = getElementsOfType(mixedTypeList)
    println("onlyBigDecimalsList: $onlyBigDecimalsList")

}

inline fun <reified T> getElementsOfType(listOfUnknownTypeObjects: List<Any>): List<T> {
    var newList: MutableList<T> = mutableListOf()
    for (element in listOfUnknownTypeObjects) {
        // The following 'if' statement would have a compilation error if the 'reified' keyword was not used!
        if (element is T) {
            newList.add(element)
        }
    }
    return newList
}

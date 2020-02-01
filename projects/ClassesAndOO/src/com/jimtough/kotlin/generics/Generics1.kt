package com.jimtough.kotlin.generics

import java.math.BigDecimal

fun main() {

    // Implicitly define generic type
    val listA: MutableList<String> = mutableListOf("alpha", "baker", "charlie", "delta")
    // Type is inferred by Kotlin
    val listB = mutableListOf("alpha", "baker", "charlie", "delta")
    printListElements(listB)

    println()

    val bdList = mutableListOf(BigDecimal(1.234), BigDecimal(-4.321), BigDecimal(444))
    printListElements(bdList)

    println()

    bdList.printElements()

}

// Example of generic function
fun <T> printListElements(collection: List<T>) {
    for (item in collection) {
        println(item)
    }
}

// Same generic function, but implemented as an extension function for List
fun <T> List<T>.printElements() {
    for (item in this) {
        println(item)
    }
}

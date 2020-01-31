package com.jimtough.kotlin.collections

fun main() {

    // NOTE: The generic types are explicitly provided for example purposes.
    //       These are redundant here, since compiler can infer them.
    val immutableMap = mapOf<Int, Car>(
        1 to Car("green", "Toyota", 2015),
        2 to Car("red", "Ford", 2016),
        3 to Car("silver", "Honda", 2013)
    )
    println(immutableMap.javaClass)
    println(immutableMap)

    val mutableMap = mutableMapOf<String, Car>(
        "John's car" to Car("tan", "Toyota", 2015),
        "Jane's car" to Car("purple", "Ford", 2016),
        "Doug's car" to Car("white", "Honda", 2013)
    )
    println(mutableMap.javaClass)
    println(mutableMap)
    mutableMap.put("Plop's car", Car("brown", "Kia", 2005))
    println(mutableMap)

    //--------------------------------------------------------------------------
    // Destructuring operations
    //--------------------------------------------------------------------------

    // The following destructuring functions work because both Pair and Map classes implement 'component functions'.
    val pair = Pair(10, "ten")
    val (firstValue, secondValue) = pair
    println(firstValue)
    println(secondValue)

    for (entry in mutableMap) {
        println(entry.key)
        println(entry.value)
    }
    println()
    for ((k,v) in mutableMap) {
        println(k)
        println(v)
    }
    println()


    val anotherMutableMap = mutableMapOf<String, DestructurableCar>(
        "John's car" to DestructurableCar("tan", "Toyota", 2015),
        "Jane's car" to DestructurableCar("grey", "Ford", 2016),
        "Doug's car" to DestructurableCar("white", "Honda", 2013),
        "Plop's car" to DestructurableCar("brown", "Kia", 2005)
    )
    // First, destructure the map element
    for ((myKey, myValue) in anotherMutableMap) {
        // Now destructure the value object
        val (color, model, year) = myValue
        println("$myKey is a $color $year $model.")
    }
    println()

    val yetAnotherMutableMap = mutableMapOf<String, DataCar>(
        "Johnnn's car" to DataCar("tan", "Toyota", 2000),
        "Janey's car" to DataCar("grey", "Ford", 2001),
        "Dougie's car" to DataCar("white", "Honda", 2002),
        "Plopp's car" to DataCar("brown", "Kia", 2003)
    )
    // First, destructure the map element
    for ((myKey, myValue) in yetAnotherMutableMap) {
        // Now destructure the value object
        val (color, model, year) = myValue
        println("$myKey is a $color $year $model.")
    }


}

open class Car(val color: String, val model: String, val year: Int)

// Implement the 'componentX()' functions, and Kotlin will recognize this class as being destructurable
class DestructurableCar(color: String, model: String, year: Int) : Car(color, model, year) {
    operator fun component1() = color
    operator fun component2() = model
    operator fun component3() = year
}

// data classes have destructuring implemented for free!
data class DataCar(val color: String, val model: String, val year: Int)

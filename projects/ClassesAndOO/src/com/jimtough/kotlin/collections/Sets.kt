package com.jimtough.kotlin.collections

fun main() {

    val immutableSetOfInts = setOf(10, 9, 8, 1, -99)
    println(immutableSetOfInts)
    // Creates a new Set with 20 added. DOES NOT modify the original set!
    println(immutableSetOfInts.plus(20))
    // Try to create a new set by adding a duplicate value, and nothing will happen (no exception, no value added)
    println(immutableSetOfInts.plus(10))
    // Create a new Set with 10 removed
    println(immutableSetOfInts.minus(10))
    // Get the average of all the values in the set
    println(immutableSetOfInts.average())
    // Remove the first X elements from the set
    println(immutableSetOfInts.drop(3))

    val mutableSetOfInts = mutableSetOf(1, 2, 3, 4)
    println(mutableSetOfInts)
    mutableSetOfInts.add(5)
    mutableSetOfInts.add(6)
    println(mutableSetOfInts)

}
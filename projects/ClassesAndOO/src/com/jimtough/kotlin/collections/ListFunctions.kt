package com.jimtough.kotlin.collections

fun main() {

    val stringsList = listOf("alpha", "baker", "charlie", "delta", "echo", "foxtrot")
    val colorsList = listOf("red", "green", "blue", "black", "white")
    val anotherColorsList = listOf("red", "orange", "yellow", "green", "blue", "indigo", "violet", "red", "red", "red")

    //------------------------------------------------------------------------------------
    // Some simple examples of methods available to lists
    //------------------------------------------------------------------------------------
    println(stringsList.last())
    println(stringsList.asReversed())
    // Get value at index, otherwise...
    println(stringsList.getOrNull(999))
    println(stringsList.getOrElse(999) {"There is no element $it"})
    // Get element with max value (I'll assume the element type must be Comparable?)
    println(colorsList.max())
    // Works the same way as the JavaScript zip function.
    // Combines the two lists into tuples and discards any overflow from longer list.
    // Kotlin uses the name 'Pair' for their tuple container class.
    println(stringsList.zip(colorsList))
    println(stringsList.zip(colorsList)[0].javaClass)
    // Create a list that has contents of both original lists using the + operator! So easy!
    val mergedLists = colorsList + stringsList
    println(mergedLists)
    // Create a list that has contents to two original list, with duplicates discarded
    val unionedLists = colorsList.union(anotherColorsList)
    println(unionedLists)
    // Create a new list from existing list with duplicates removed
    val distinctList = anotherColorsList.distinct()
    println(distinctList)
    //------------------------------------------------------------------------------------
    
}
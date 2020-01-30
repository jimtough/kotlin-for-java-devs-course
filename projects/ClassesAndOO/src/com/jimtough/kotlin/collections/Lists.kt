package com.jimtough.kotlin.collections

fun main() {

    val stringsList = listOf("alpha", "baker", "charlie", "delta")
    println("Type of stringsList: ${stringsList.javaClass}")

    // Need to specify the generic type of one side of the declaration statement
    val emptyListA = emptyList<String>()
    println("Type of emptyListA: ${emptyListA.javaClass}")
    val emptyListB: List<String> = emptyList()
    println("Type of emptyListB: ${emptyListB.javaClass}")

    // This isn't what one might expect. The null vararg that I pass it is simply ignored.
    val notNullList = listOfNotNull("hello", null, "goodbye")
    println(notNullList)

    val arrayList = arrayListOf(1, 2, 3, 4)
    println("Type of arrayList: ${arrayList.javaClass}")

    // Mutable lists can be modified, as one would expect
    var mutableList = mutableListOf<Int>(1, 2, 3)
    println("Type of mutableList: ${mutableList.javaClass}")
    mutableList[1] = 2000
    mutableList.add(4000)
    println(mutableList)

    val array = arrayOf("black", "white", "green")
    // one way to do it...
    //val colorList = listOf(*array)
    // ...and another way
    val colorList = array.toList()
    println(colorList)

    val intArray = intArrayOf(1, 2, 3, 4, 5)
    println(intArray.toList())

}
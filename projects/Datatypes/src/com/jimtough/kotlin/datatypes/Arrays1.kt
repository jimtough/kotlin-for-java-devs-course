package com.jimtough.kotlin.datatypes

import com.jimtough.java.datatypes.DummyClass
import java.math.BigDecimal
import java.util.*

fun main(args: Array<String>) {

    val namesArray = arrayOf("John", "Jane", "Jill", "Joe")
    val longs1 = arrayOf(1L, 2L, 3L)
    val longs2 = arrayOf<Long>(1, 2, 3, 4)
    val ints1 = arrayOf(1, 2, 3, 4)

    println(longs1 is Array<Long>)
    println(longs2 is Array<Long>)
    println(ints1 is Array<Int>)
    println(longs1[2])

    // Arrays can be initialized via a lambda expression, where the input to the lambda is the array index
    val evenNumbersArray = Array(16) {i -> i * 2}
    // These two statements yield the same result
    println(Arrays.toString(evenNumbersArray))
    println(evenNumbersArray.contentToString())

    // Arrays can be initialized with the same value in every element
    val allZeros = Array(50) { 0 }
    println(allZeros.contentToString())

    // Declare an array reference, but assign it a value later. Need to specify the array type in this case.
    var someArray: Array<Int>
    someArray = arrayOf(1, 2, 3, 4)
    println(someArray.contentToString())
    // The following lines weren't part of the course material
    //println(someArray::class.qualifiedName)
    //println(someArray.javaClass.typeName)

    // Declare an array and create it with a mix of different data types.
    val mixedTypesArray = arrayOf("hello", 22, BigDecimal(10.5), 'a')
    println(mixedTypesArray.contentToString())
    // The following lines weren't part of the course material
    //println(mixedTypesArray::class.qualifiedName)
    //println(mixedTypesArray.javaClass.typeName)
    println("Is 'mixedTypesArray' an Array<Any>? ${mixedTypesArray is Array<Any>}")

    // This will not work, because Kotlin does not create primitive 'int' arrays by default...
    //val myIntArray = arrayOf(3, 9, 434, 2, 33)
    //DummyClass().printPrimitiveIntArray(myIntArray)
    // ... so do this instead
    val myIntArray = intArrayOf(3, 9, 434, 2, 33)
    DummyClass().printPrimitiveIntArray(myIntArray)

    // Create a primitive int array of size 5. Will be initialized with zeroes.
    var someOtherArray = IntArray(5)
    println(someOtherArray.contentToString())

    // Kotlin can convert an Array<Int> to an IntArray via a built-in conversion method
    DummyClass().printPrimitiveIntArray(evenNumbersArray.toIntArray())

    // It can also convert a primitive IntArray to a typed array
    val yetAnotherArray: Array<Int> = myIntArray.toTypedArray()

}










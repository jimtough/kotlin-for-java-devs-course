package com.jimtough.kotlin.datatypes

import com.jimtough.java.datatypes.DummyClass

fun main(args: Array<String>) {
    val myInt = 10
    var myLong = 22L
    // Error! No automatic widening of number type variables in Kotlin, unlike Java.
    //myLong = myInt
    myLong = myInt.toLong()

    val myByte: Byte = 111
    var myShort: Short
    myShort = myByte.toShort()

    // Default floating point type is Double, like in Java
    var myDouble = 65.984
    println(myDouble is Double)

    val myFloat = 838.8492f
    println("Is 'myFloat' a Float? ${myFloat is Float}")

    val myChar1 = 'b'
    val int65 = 65
    val myChar2: Char = int65.toChar()
    println(myChar1 + " " + myChar2)

    val myBoolean = true

    val whatever = true
    val whateverResult = DummyClass().isWhatever(whatever)
    println(whateverResult)

}
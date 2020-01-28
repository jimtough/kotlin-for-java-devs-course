package com.jimtough.kotlin.nullrefs

fun main() {

    val nullableInts = arrayOfNulls<Int?>(5)
    for (i in nullableInts) {
        println(i)
    }

    println("Element 3 is: ${nullableInts[3]}")

}















package com.jimtough.kotlin.nullrefs

fun main() {

    //val strA: String? = "This isn't null"
    val strA: String? = null

    // The 'let' function accepts a lambda expression inside the braces.
    // The original reference (strA in this case) is referenced in the lamdba
    // by the keyword 'it'.
    // Use 'let' to execute the lambda, but only if 'strA' is not null when the call happens.
    strA?.let { printTheString3(it) }

    val nullableStr : String? = null
    val notNullableStr = "This isn't nullable"
    // Kotlin has no issues with the null passed to the check below. Result is false of course.
    println(nullableStr == notNullableStr)

}

fun printTheString3(s: String) {
    println("Inside printTheString3")
    println(s)
}


















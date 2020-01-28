package com.jimtough.kotlin.nullrefs

fun main() {

    //val strA: String? = "This isn't null"
    val strA: String? = null

    // The '!!' operator means 'Assume the reference is not null'.
    // If 'str' is actually null, then an exception will be thrown ON THE LINE BELOW!
    // This is unlike Java, where the exception is thrown when the null reference is used.
    val strB = strA!!

    // We will never reach the next line if 'strA' was null. This is a good thing.
    // In Java, the method call would have happened, and the NullPointerException would happen inside it.
    printTheString2(strB)

}

fun printTheString2(s: String) {
    println(s)
}


















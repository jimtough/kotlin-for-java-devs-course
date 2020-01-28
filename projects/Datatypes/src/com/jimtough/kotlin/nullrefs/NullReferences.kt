package com.jimtough.kotlin.nullrefs

fun main() {

    // The following is not allowed.
    // Kotlin will prevent you from assigning null to a normal object reference.
    //val str: String = null

    // If you put a ? after the reference datatype, it indicates that you don't want
    // Kotlin to prevent you from assigning a null value to this reference.
    //var str: String? = "This isn't null"
    var str: String? = null

    // The following is not allowed, because you declared 'str' as a nullable reference.
    // Kotlin will just assume that this reference *might* be null everywhere it appears.
    //str.toUpperCase()

    // Java-style null check around the 'str' reference will make it safe inside that block
    if (str != null) {
        // If 'str' is null, then the line below is never reached
        println("The value of 'str' is: ${str.toUpperCase()}")
    }
    // Concise Kotlin-style null check, using the ? after the reference
    // In this case, the println() will execute. The 'str?.toUpperCase()' evaluates to the value null,
    // rather than causing a NullPointerException as it would have in Java when 'toUpperCase()' is invoked on a null.
    println("The value of 'str' is: ${str?.toUpperCase()}")

    str = null
    // The '?:' operator is referred to as the 'Elvis operator' in Kotlin
    val str2: String = str ?: "This is the default value to use if 'str' is null"
    println("The value of 'str2' is: $str2")


}


















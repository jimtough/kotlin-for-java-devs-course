package com.jimtough.kotlin.objectkeyword

fun main() {

    // Note how the 'object' keyword is used where we create an anonymous class instance.
    // Instance is used, and then discarded (not a singleton!).
    wantsSomeInterfaceInstance(13, object: SomeInterface {
        override fun mustImplement(i: Int): String = "$i is a boring number"
    })

}

interface SomeInterface {
    fun mustImplement(i: Int): String
}

fun wantsSomeInterfaceInstance(i: Int, si: SomeInterface) {
    println(si.mustImplement(i))
}


package com.jimtough.kotlin.imports

fun main() {
    topLevelFunction("foobar")
}

fun topLevelFunction(s: String) {
    println("Inside topLevelFunction() - Your string: '$s'")
}

internal fun internalTopLevelFunction(s: String) {
    println("Inside internalTopLevelFunction() - Your string: '$s'")
}

package com.jimtough.kotlin.generics

import java.time.LocalDateTime

fun main() {

    val listOfInts = listOf(1, 2, 3, 4, 5)
    val listOfShorts: List<Short> = listOf(10, 20, 30, 40)
    val listOfFloats: List<Float> = listOf(11f, 12.34f, 33.33f)

    println(convertToIntList(listOfInts))
    println(convertToIntList(listOfShorts))
    println(convertToIntList(listOfFloats))

    val sb = StringBuilder()
    val listOfStrings = listOf("alpha", "baker", "charlie", "delta")
    for (s in listOfStrings) {
        append(sb, s)
        append(sb, " ")
    }
    // Now throw in a null...
    append(sb, null)
    println(sb.toString())

    println()
    printAnyNonNullObject(LocalDateTime.now())
    printAnyNonNullObject(Any())
    printAnyNonNullObject("hi mom!")

    val anyReferenceToListOfStrings: Any = listOf("str1", "str2")
    // The following line would be a compilation error, due to runtime type erasure
    //if (anyReferenceToListOfStrings is List<String>) {
    // We can only know for sure at runtime that the reference is to 'a List of something'
    if (anyReferenceToListOfStrings is List<*>) {
        println("anyReferenceToListOfStrings refers to a List")
    }
    val anyReferenceToSomethingThatIsNotAList: Any = "some string"
    if (anyReferenceToSomethingThatIsNotAList is List<*>) {
        println("anyReferenceToSomethingThatIsNotAList refers to a List")
    } else {
        println("anyReferenceToSomethingThatIsNotAList DOES NOT refer to a List")
    }

    println("Is listOfShorts a list of strings? ${nativeIsListOfStrings(listOfShorts)}")
    println("Is listOfStrings a list of strings? ${nativeIsListOfStrings(listOfStrings)}")
    println("Is anyReferenceToListOfStrings a list of strings? ${nativeIsListOfStrings(anyReferenceToListOfStrings)}")
    println("Is anyReferenceToSomethingThatIsNotAList a list of strings? ${nativeIsListOfStrings(anyReferenceToSomethingThatIsNotAList)}")

}

fun <T: Number> convertToIntList(listOfNumbers: List<T>): List<Int> {
    val listOfInts: MutableList<Int> = ArrayList()
    for (n in listOfNumbers) {
        listOfInts.add(n.toInt())
    }
    return listOfInts
}

// Multiple generic types, with type constraints list in a Kotlin 'where' clause.
// Note the use of '?' on the type constraint for U, to indicate that nulls are allowed.
fun <T,U> append(appendToMe: T, thingToAppend: U) where T: CharSequence, T:Appendable, U: CharSequence? {
    appendToMe.append(thingToAppend)
}

fun <T: Any> printAnyNonNullObject(o: T) {
    println(o)
}

fun nativeIsListOfStrings(couldBeAnything: Any): Boolean {
    if (couldBeAnything !is List<*>) {
        return false
    }
    val listOfSomethings: List<*> = couldBeAnything
    for (o in listOfSomethings) {
        if (o !is String) {
            return false
        }
    }
    return true
}

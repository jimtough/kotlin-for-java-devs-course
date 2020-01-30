package com.jimtough.kotlin.ifExpression

fun main() {

    var x = 123
    var y = 321

    // verbose syntax
    var intA: Int
    if (x < y) {
        intA = 111
    } else {
        intA = 222
    }

    // concise syntax
    // NOTE: You MUST provide an 'else' if using this syntax. The entire expression must always return a value.
    var intB: Int
    intB = if (x < y) 333 else 444

    // concise syntax for an 'if' that doesn't return a value
    if (x < y) println("x is less than y") else println("x is not less than y")
    // We expect the type returned from the above to be 'Unit' (meaning no return value)
    val returnedValueObject = if (x < y) println("hi") else println("oh hello!")
    println("type returned: ${returnedValueObject.javaClass}")

    // You can also inline 'if' expressions that return a value
    println(if (x < y) 333 else 444)

}
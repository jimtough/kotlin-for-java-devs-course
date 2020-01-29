package com.jimtough.kotlin.inheritance

fun main() {

    val a = MyParentClass(3)
    val b = MyParentClass(13, "Hoochie mama!")
    val c = MyChildClass(5)
    val d = MyChildClass(7, "D'oh!", true)
    val e = MyGrandchildClass(42)

    a.printStuff()
    b.printStuff()
    c.printStuff()
    d.printStuff()
    e.printStuff()

}


// NOTE: This is example code only! Typically you should avoid using secondary constructors in real code!


// NOTE: I left in the 'constructor' keyword for the primary constructor, for example purposes
open class MyParentClass constructor(private val paramA: Int) {

    private var paramB: String = "NO VALUE PROVIDED!"
    private var paramC: Boolean = false

    // Declare a secondary constructor, and delegate to primary constructor
    constructor(paramA: Int, paramB: String) : this(paramA) {
        this.paramB = paramB
    }

    // Declare another secondary constructor, and delegate to other secondary constructor
    constructor(paramA: Int, paramB: String, paramC: Boolean) : this(paramA, paramB) {
        this.paramC = paramC
    }

    fun printStuff() {
        println("I like the number $paramA, and I like to say '$paramB'. Am I telling the truth? $paramC.")
    }

}

// Extend the parent class, and delegate to one of its secondary constructors
open class MyChildClass constructor(paramA: Int, paramB: String, paramC: Boolean) : MyParentClass(paramA, paramB, paramC) {

    // Declare a secondary constructor, and delegate to the primary constructor of this class
    constructor(paramA: Int) : this(paramA, "(your ad here)", false)

}

// Extend the child class, and delegate to its primary constructor
class MyGrandchildClass constructor(paramA: Int) : MyChildClass(paramA, "This sh!t is bananas!", true)

package com.jimtough.kotlin.interfaces

fun main() {

    val a = TheParentClass("Hoochie mama!")
    val b = TheChildClass("I like big decimals and I can not lie!")
    val c : StringGenerator = TheParentClass("WAZZZZZUP!")
    val d : FancyStringGenerator = TheChildClass("That was already NOT funny 20 years ago!")

    println(a.generateString())
    println(b.generateString())
    println(b.generateFancyString('*'))
    println(c.generateString())
    println(d.generateFancyString('$'))
    println(a.someNumber)
    println(b.someOtherNumber)

}

interface StringGenerator {
    // Kotlin interfaces do not force values defined in interfaces to be constants.
    // Note that no value is specified for 'someNumber'. The implementing class must define this!!!
    val someNumber: Int

    fun generateString(): String
}

interface FancyStringGenerator : StringGenerator {
    // This seems like a strange way to provide a value for an interface property, but Kotlin supports it
    val someOtherNumber: Int
        get() = 99

    fun generateFancyString(fancyChar: Char): String
}

open class TheParentClass constructor(protected val someString: String): StringGenerator {
    // In the next line, I provide a value for the 'someNumber' property defined in the interface
    override val someNumber: Int = 42
    // In the next line, I implement the interface function
    override fun generateString(): String {
        return someString
    }
}

class TheChildClass constructor(someString: String) : TheParentClass(someString), FancyStringGenerator {
    override fun generateFancyString(fancyChar: Char): String {
        return "$fancyChar$fancyChar$fancyChar $someString $fancyChar$fancyChar$fancyChar"
    }
}

package com.jimtough.kotlin.inheritance

fun main() {
    val laserPrinter = LaserPrinter("Samsung XYZ123")
    laserPrinter.printModel()
}

// Kotlin 'open' keyword means this class is open for extension and is NOT final (final is the default in Kotlin)
// NOTE: Any abstract class must also be 'open', so explicitly using 'open' here is redundant
open abstract class Printer(val modelName: String) {

    // 'open' keyword means this function is non-final and can be overridden
    open fun printModel() = println("The model name of this printer is $modelName")
    abstract fun bestSellingPrice(): Double

}

class LaserPrinter(modelName: String): Printer(modelName) {

    // In Kotlin, 'override' is a keyword and not just an annotation like in Java
    override fun printModel() = println("The model name of this LASER printer is $modelName")
    // dumb function implementation for example purposes...
    override fun bestSellingPrice(): Double = 129.99

}

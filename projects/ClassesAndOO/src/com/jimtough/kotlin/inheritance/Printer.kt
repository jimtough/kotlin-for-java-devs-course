package com.jimtough.kotlin.inheritance

fun main() {
    val laserPrinter = SpecialLaserPrinter("Samsung XYZ123")
    laserPrinter.printModel()
}

// Kotlin 'open' keyword means this class is open for extension and is NOT final (final is the default in Kotlin)
// NOTE: Any abstract class must also be 'open', so explicitly using 'open' here is redundant
open abstract class Printer(val modelName: String) {

    // 'open' keyword means this function is non-final and can be overridden
    open fun printModel() = println("The model name of this printer is $modelName")
    abstract fun bestSellingPrice(): Double

}

open class LaserPrinter(modelName: String, someOtherParam: Int): Printer(modelName) {

    // In Kotlin, 'override' is a keyword and not just an annotation like in Java.
    // The 'override' keyword also implicitly makes this function 'open', so it must
    // be declared 'final' if you want to prevent any other subclasses from overriding it.
    final override fun printModel() = println("The model name of this LASER printer is $modelName")
    // dumb function implementation for example purposes...
    override fun bestSellingPrice(): Double = 129.99

}

// Notice how the 'someOtherParam' added to the primary constructor of the parent class forces
// this class to provide a value (I used zero). This is similar to Java.
class SpecialLaserPrinter(modelName: String) : LaserPrinter(modelName, 0) {

    // This is now prevented, because parent class explicitly marked function as 'final'
    //override fun printModel() = println("my way, or the HIGHWAY!")

}

//-------------------------------------------------------------------









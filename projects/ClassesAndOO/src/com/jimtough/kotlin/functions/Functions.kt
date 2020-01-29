package com.jimtough.kotlin.functions

// In Kotlin, a function that returns nothing is implicitly defined to return Unit.
// This is similar to a void method in Java.
fun main(): Unit {
    println(labelMultiplyVerbose(3, 4, "The result is: "))
    println(labelMultiplyConcise(3, 4, "The result is: "))
    println(labelMultiplyMoreConcise(3, 4, "The result is: "))
    println(labelMultiplyWithDefaultLabel(3, 4))
    // You can optionally provide arguments by name, in any order.
    // If you name any argument, you must name them all.
    println(labelMultiplyMoreConcise(operandB = 4, label = "The result is: ", operandA = 3))
    val empA = Employee("Joe")
    println(empA.upperCaseFirstName())

    val car1 = Car("blue", "Toyota", 2015)
    val car2 = Car("red", "Pontiac", 1999)
    val car3 = Car("black", "Mercedes", 2016)
    // If the vararg is not the last parameters of the function,
    // then you must use named arguments for the other arguments.
    printCarColors1(car1, car2, car3, someString = "Does anyone car?")
    printCarColors2("Guess what?", car1, car2, car3)

    val arrayOfCars = arrayOf(car1, car2, car3)
    // Unlike Java, you cannot pass an array reference where a vararg is expected.
    // The following line would cause a compilation error.
    //printCarColorsVarargOnly(arrayOfCars)
    // SOLUTION - The Kotlin 'spread' operator. Put * in front of the array reference.
    //            This unpacks the array so a vararg can consume the elements.
    printCarsVarargOnly(*arrayOfCars)

    println()

    val car4 = car2.copy(color = "tan", year = 1993)
    // You can even add some more objects after the unpacked array elements!
    printCarsVarargOnly(*arrayOfCars, car4)

    // Compare utility function versus 'extension function'
    println(upperFirstAndLast("mordor"))
    println("hobbiton".capitalizeFirstAndLast())

    println(labelMultiplyInline(9, 9, "Result of my inline multiple function is: "))

}

// The return type comes at the end of the method signature, following a colon
fun labelMultiplyVerbose(operandA: Int, operandB: Int, label: String): String {
    return ("$label ${operandA * operandB}")
}

// If the method body is a single line, then a more concise format can be used.
// This is referred to as a function with 'an expression body'.
// NOTE: The whole thing could be on one line, but I put the method body on a separate line for readability.
fun labelMultiplyConcise(operandA: Int, operandB: Int, label: String): String =
    "$label ${operandA * operandB}"

// Return type can be inferred by the compiler, so it can be omitted
fun labelMultiplyMoreConcise(operandA: Int, operandB: Int, label: String) = "$label ${operandA * operandB}"

// You may define default values for parameters
fun labelMultiplyWithDefaultLabel(operandA: Int, operandB: Int, label: String = "The answer is: ") =
    "$label ${operandA * operandB}"

class Employee(val firstName: String) {

    fun upperCaseFirstName() = firstName.toUpperCase()

}

// Kotlin supports vararg parameters. Only one per function is allowed.
fun printCarColors1(vararg cars: Car, someString: String) {
    for (car in cars) {
        println("This is a ${car.color} car. " + someString)
    }
}

fun printCarColors2(someString: String, vararg cars: Car) {
    for (car in cars) {
        println(someString + " This is a ${car.color} car. ")
    }
}

fun printCarsVarargOnly(vararg cars: Car) {
    for (car in cars) {
        println("This ${car.color} thing is a car from ${car.year}, apparently.")
    }
}

data class Car(val color: String, val model: String, val year: Int)

// Traditional utility function...
fun upperFirstAndLast(str: String): String {
    val upperFirst = str.substring(0, 1).toUpperCase() + str.substring(1)
    return upperFirst.substring(0, upperFirst.length - 1) +
            upperFirst.substring(upperFirst.length - 1, upperFirst.length).toUpperCase()
}

// Same code as function above, but implemented as an 'extension function'.
// It will appear to be associated with the String class, but does not actually 'extend' the String class.
// NOTE:
//   - 'String.' tells compiler what class you want function associated with
//   - 'str' parameter is gone, because you now invoke this method ON a String object!
//   - Use 'this' in the function body to refer to the String object
fun String.capitalizeFirstAndLast(): String {
    val upperFirst = this.substring(0, 1).toUpperCase() + this.substring(1)
    return upperFirst.substring(0, upperFirst.length - 1) +
            upperFirst.substring(upperFirst.length - 1, upperFirst.length).toUpperCase()
}

// A (silly) inline function, for example only
inline fun labelMultiplyInline(operandA: Int, operandB: Int, label: String) = "$label ${operandA * operandB}"

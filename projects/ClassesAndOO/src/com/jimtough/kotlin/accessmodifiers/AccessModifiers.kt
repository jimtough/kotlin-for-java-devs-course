package com.jimtough.kotlin.accessmodifiers

fun main() {
    val myPrivateClassInstance = MyPrivateClass()
    println(myPrivateClassInstance)
    val vEmp = KotlinVerboseEmployee("John")
    println(vEmp.firstName)
    val cEmp = KotlinConciseEmployee("Jane")
    println(cEmp.firstName)

    val emp1 = EmployeeWithSecondaryConstructor("Duke", false)
    val emp2 = EmployeeWithSecondaryConstructor("Bob")
    println("${emp1.firstName} | ${emp1.fullTime}")
    println("${emp2.firstName} | ${emp2.fullTime}")

    val emp3 = EmployeeWithParameterThatHasDefaultValue("Mark", false)
    val emp4 = EmployeeWithParameterThatHasDefaultValue("Plop")
    println("${emp3.firstName} | ${emp3.fullTime}")
    println("${emp4.firstName} | ${emp4.fullTime}")

    println(NoPrimaryConstructor().dummy)
}

// Notice the top-level class with a 'private' modifier. This would make no sense in Java.
// In Kotlin, a private class is accessible to other code in the same .kt file.
private class MyPrivateClass {

}

public final class KotlinVerboseEmployee public constructor(firstName: String) {

    val firstName: String

    // init block is used in conjunction with the primary constructor.
    // You may have multiple init blocks in a class, but that is not typical.
    init {
        this.firstName = firstName
    }

}

// By default, classes are 'public final' in Kotlin.
class KotlinConciseEmployee(val firstName: String)

//-----------------------------------------------------------------------------

class EmployeeWithSecondaryConstructor(val firstName: String) {

    var fullTime: Boolean = true

    // This is a 'secondary' constructor. The 'this(firstName)' part is where it delegates to the primary constructor.
    // Note that the secondary constructor arguments DO NOT result in automatic creation of class properties.
    constructor(firstName: String, fullTime: Boolean) : this(firstName) {
        this.fullTime = fullTime
    }
}

class EmployeeWithParameterThatHasDefaultValue(val firstName: String, var fullTime: Boolean = true)

//-----------------------------------------------------------------------------

class NoPrimaryConstructor {
    val dummy: String = "I am dumb"
}






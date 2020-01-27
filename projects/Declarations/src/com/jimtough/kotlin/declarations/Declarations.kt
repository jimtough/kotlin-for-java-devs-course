package com.jimtough.kotlin.declarations

fun main(args: Array<String>) {
    // Either way is fine - Kotlin will infer the type whenever possible
    //var number: Int = 25
    var number = 25
    number = 10

    // Cannot change a 'val' after it has been assigned
    val immutableNumber = 30

    // Explicitly define type because it is not the default type
    var shortNumber : Short = 20

    // Object reference 'employee1' is immutable, but the object properties are mutable as expected
    val employee1 = Employee("Lynn Jones", 500)
    employee1.name = "Lynn Smith"

    val employee2: Employee
    val number2 = 100

    if (number < number2) {
        employee2 = Employee("Jane Smith", 400)
    } else {
        employee2 = Employee("Mike Watson", 150)
    }

    // Not allowed! Type of 'number' is already set above and cannot be altered.
    //number = "Hello"
}

class Employee(var name: String, val id : Int) {

}
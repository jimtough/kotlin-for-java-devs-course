package com.jimtough.kotlin.declarations

typealias EmployeeSet = Set<Employee>

fun main(args: Array<String>) {

    val employeeOne = Employee("Mary", 1)
    val employeeTwo = Employee("John", 2)
    val employeeThree = Employee("John", 2)
    val employeeFour = employeeTwo

    println(employeeOne == employeeTwo)
    println(employeeTwo == employeeThree)
    println(employeeOne.equals(employeeTwo))
    println(employeeTwo.equals(employeeThree))
    println(employeeFour === employeeTwo)
    println(employeeFour != employeeTwo)
    println(employeeFour !== employeeTwo)
    println(employeeTwo != employeeThree)
    println(employeeTwo !== employeeThree)

    // Bit operators in Kotlin use natural language syntax instead of &, |, ^ operators
    val x = 0x00101101
    val y = 0x11011011
    x or y
    x and y
    x xor y

    // Kotlin does not use 'instanceof' - use 'is' and '!is' instead
    val something: Any = employeeFour
    if (something is Employee) {
        // Use the 'as' keyword to explicitly cast reference type.
        val newEmployee = something as Employee
        println(newEmployee.name)
        // Note that Kotlin 'Smart Casting' makes the explicit cast above unnecessary!
        println(something.name)
    }

    // Either way is fine - Kotlin will infer the type whenever possible
    //var number: Int = 25
    var number = 25
    number = 10

    val names = arrayListOf("John", "Jane", "Mary")
    println(names[1])

    val employees: EmployeeSet

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
}

class Employee(var name: String, val id : Int) {

    override fun equals(obj: Any?): Boolean {
        if (obj is Employee) {
            return name == obj.name && id == obj.id
        }
        return false
    }

}

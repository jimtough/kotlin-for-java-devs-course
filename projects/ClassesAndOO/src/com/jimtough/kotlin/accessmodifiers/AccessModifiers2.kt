package com.jimtough.kotlin.accessmodifiers

fun main() {
    val emp1 = EmployeeWithExplicitGetterAndSetter("Duke", false)
    val emp2 = EmployeeWithExplicitGetterAndSetter("Bob")
    println("${emp1.firstName} | ${emp1.fullTime}")
    println("${emp2.firstName} | ${emp2.fullTime}")
    // Getters and Setters for class properties are automatically generated.
    // This is what allows the statement below to work.
    emp1.fullTime = true
    // Note that 'val' properties are final, and have no setter generated.
    // The statement below will cause a compilation error
    //emp1.firstName = "Jimbo"
    println("${emp1.firstName} | ${emp1.fullTime}")
}

class Employee(val firstName: String, var fullTime: Boolean = true)

class EmployeeWithExplicitGetterAndSetter(val firstName: String, fullTime: Boolean = true) {

    // The custom getter must immediately follow the backing field declaration
    var fullTime = fullTime
    get() {
        println("Running the custom get")
        // The 'field' keyword is the only way to reference the backing field
        return field
    }
    set(value) {
        println("Running the custom set")
        field = value
    }

}







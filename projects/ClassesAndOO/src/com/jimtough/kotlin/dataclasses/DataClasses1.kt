package com.jimtough.kotlin.dataclasses

val MY_CONSTANT = 100

fun main() {

    println("MY_CONSTANT is: $MY_CONSTANT")
    val car1 = Car("red", "Ford", 1999)
    println(car1)
    val car2 = Car("red", "Ford", 1999)
    println(car2)
    println("car1 == car2? ${car1 == car2}")
    println("car1 === car2? ${car1 === car2}")
    // Copy the entire object
    val car3 = car1.copy()
    println(car3)
    // Copy the entire object, except for the property values I explicitly replace
    // Note the use of a named parameter below
    val car4 = car1.copy(color = "black")
    println(car4)

}

// data classes get the following for free:
//  - toString function
//  - implementations of equals() and hashCode() functions
//  - copy function
// data classes have some special requirements/constraints (not covered until later in the course)
data class Car(val color: String, val model: String, val year: Int) {
    
}








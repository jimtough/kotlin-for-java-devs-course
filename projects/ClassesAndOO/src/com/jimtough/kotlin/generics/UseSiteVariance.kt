package com.jimtough.kotlin.generics

fun main() {

    val cars1 = mutableListOf(Car(), Car())
    val cars2: MutableList<Car> = mutableListOf()
    copyCarsA(cars1, cars2)

    val fords1 = mutableListOf(Ford(), Ford())
    val fords2: MutableList<Ford> = mutableListOf()
    // This is not allowed, because the types expected in copyCarsA() are invariant
    //copyCarsA(fords1, fords2)
    // But this works. The copyCarsB() method is happy as long as both lists are of the exact same type.
    copyCarsB(fords1, fords2)

    // But now what happens if we want to copy a list of Ford cars into a list of 'Car'?
    // 'copyCarsA()' won't work, because it only allows list of Car
    //copyCarsA(fords1, cars2)
    // 'copyCarsB()' won't work, because both lists must be exactly the same type
    //copyCarsB(fords1, cars2)
    // Yay! Adding the 'out' modifier to type T on the 'source' parameter resolves the problem!
    copyCarsC(fords1, cars2)

    // This does not work, nor should it!
    // If this was allowed, then we could end up with other Car types added to a list of Ford.
    //copyCarsC(cars1, fords2)

}

fun copyCarsA(source: MutableList<Car>, destination: MutableList<Car>) {
    for (car in source) {
        destination.add(car)
    }
}

fun <T> copyCarsB(source: MutableList<T>, destination: MutableList<T>) {
    for (car in source) {
        destination.add(car)
    }
}

// The 'source' list is never modified (only read operations), so the 'out' modifier yields the behaviour we want.
// This is called 'use-site variance', because we have modified the type constraints on a function parameter,
// but it was not necessary to modify the classes involved. Car and Ford are not generic.
fun <T: Car> copyCarsC(source: MutableList<out T>, destination: MutableList<T>) {
    for (car in source) {
        destination.add(car)
    }
}

open class Car {

}

class Toyota: Car() {

}

class Ford: Car() {

}
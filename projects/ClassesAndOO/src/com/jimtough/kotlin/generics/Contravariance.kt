package com.jimtough.kotlin.generics

fun main() {

    // How do we avoid repetitive code like this?
    val roseTender = object: FlowerCare<Rose> {
        override fun prune(flower: Rose) = println("I am pruning a Rose. (I only know how to prune roses!)")
    }
    val daffodilTender = object: FlowerCare<Daffodil> {
        override fun prune(flower: Daffodil) = println("I am pruning a Daffodil. (I only know how to prune daffodils!)")
    }

    // We really want a generic implementation like this:
    val flowerTender = object: FlowerCare<Flower> {
        override fun prune(flower: Flower) = println("I am tending to a ${flower.flowerTypeName}!")
    }

    val roseGarden = Garden<Rose>(listOf(Rose(), Rose()), roseTender)
    roseGarden.tendFlower(0)

    val daffodilGarden = Garden<Daffodil>(listOf(Daffodil(), Daffodil(), Daffodil()), daffodilTender)
    daffodilGarden.tendFlower(2)

    val roseGardenWithGenericFlowerCare = Garden<Rose>(listOf(Rose(), Rose()), flowerTender)
    roseGardenWithGenericFlowerCare.tendFlower(0)

}

class Garden<T: Flower> (private val flowers: List<T>, private val flowerCare: FlowerCare<T>) {
    fun tendFlower(i: Int) {
        flowerCare.prune(flowers[i])
    }
}

open class Flower(val flowerTypeName: String) {

}

class Rose: Flower("Rose") {

}

class Daffodil: Flower("Daffodil") {

}

// The 'in' modifier allows the type to match T or any of its supertypes.
// This allows me to create the generic FlowerCare<Flower> implementation above.
interface FlowerCare<in T> {
    fun prune(flower: T)
    // This, however, would not work. Now that the type parameter T is 'in',
    // it cannot be used 'in the out position'. In other words, cannot be a generic return value type.
    //fun pick(): T
}

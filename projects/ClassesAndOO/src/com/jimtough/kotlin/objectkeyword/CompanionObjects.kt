package com.jimtough.kotlin.objectkeyword

import kotlin.random.Random

fun main() {
    println(SomeClass.Companion.accessPrivateVar())
    println(SomeClass.Companion.accessPrivateVar())
    // note that specifying the companion object name is optional
    println(SomeClass.accessPrivateVar())
    println()
    println(SomeOtherClass.LilBuddy.accessBuddyVar())
    println(SomeOtherClass.LilBuddy.accessBuddyVar())
    println(SomeOtherClass.accessBuddyVar())
    println()
    println(ClassWithPrivateConstructor.newInstance().intVal)
    println(ClassWithPrivateConstructor.newInstance().intVal)

}

class SomeClass {
    // Unnamed companion object
    companion object {
        private var privateVar = 0
        fun accessPrivateVar() = "Value of privateVar is ${++privateVar}"
    }
}

class SomeOtherClass {
    // Named companion object
    companion object LilBuddy {
        private var buddyVar = Random.Default.nextInt(0, 1000)
        fun accessBuddyVar() = "Value of buddyVar is ${++buddyVar}"
    }
}

// Example of using companion object as a factory for the enclosing class
class ClassWithPrivateConstructor private constructor(val intVal: Int) {
    companion object Factory {
        fun newInstance(): ClassWithPrivateConstructor {
            val i = Random.Default.nextInt(0, 100)
            return ClassWithPrivateConstructor(i)
        }
    }
}

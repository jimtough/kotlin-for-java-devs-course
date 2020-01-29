package com.jimtough.kotlin.objectkeyword

import java.time.Year

fun main() {
    println(Jingleton.getYearGreeting())
    println(Jingleton.getHelloWorld())
    println(Jingleton.jingleAllTheWay)
}

// This is a singleton in Kotlin
object Jingleton {

    private val currentYear = Year.now().value
    val jingleAllTheWay = "Oh what fun it is to ride..."

    fun getYearGreeting() = "Happy $currentYear!"
    fun getHelloWorld() = "Hello, World!"

}
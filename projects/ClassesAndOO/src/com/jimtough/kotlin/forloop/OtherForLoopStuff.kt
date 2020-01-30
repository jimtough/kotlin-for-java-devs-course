package com.jimtough.kotlin.forloop

fun main() {

    // Nested loops
    for (i in 1..3) {
        println("i is $i")
        // NAMED LOOP - can be referred to in a 'break' statement within a nested loop
        jloop@ for (j in 1..3) {
            println("i,j is $i,$j")
            for (k in 1..99) {
                println("i,j,k is $i,$j,$k")
                if (k == 4) {
                    // break and exit from 'jloop' instead of this loop
                    break@jloop
                }
            }
        }
    }

}
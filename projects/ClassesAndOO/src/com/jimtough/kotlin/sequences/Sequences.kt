package com.jimtough.kotlin.sequences

import com.jimtough.kotlin.collections.DataCar

// NOTE: Kotlin sequences are very similar to Java 8 Streams.
//       Like Java Streams, it only makes sense to use sequences for large data sets.
//       The code below is just for example purposes.

fun main() {

    // Uses my 'DataCar' class from Maps.kt
    val dataCarMap = mapOf<String, DataCar>(
        "Johnnn's car" to DataCar("grey", "Toyota", 2010),
        "Janey's car" to DataCar("grey", "Ford", 2011),
        "Dougie's car" to DataCar("white", "Ford", 2012),
        "Bruce's car" to DataCar("white", "Ford", 2017),
        "Plopp's car" to DataCar("brown", "Kia", 2018)
    )

    val resultsA: List<String> = dataCarMap.asSequence()
        // Intermediate sequence operation...
        .filter { it.value.model == "Ford" }
        // Another intermediate sequence operation...
        .map { "${it.key} is a ${it.value.color} ${it.value.year} ${it.value.model}." }
        // We are still working with a Sequence, so we need to output the sequence data
        // some form that we can consume.
        // Like Java Streams, this is referred to as a 'terminal operation'. It will
        // close out the sequence.
        .toList()
    println("Results should contain only Ford cars")
    println(resultsA)

    dataCarMap.asSequence()
        // Note use of rarely seen semi-colon in the predicate expressions  :)
        .filter { println("Inside a sequence filter: [${it.key}]"); it.key.startsWith("J") }
        .map { println("Inside a sequence map: [${it.key}]"); "${it.key} is a ${it.value.color} ${it.value.year} ${it.value.model}." }
    println("SURPRISE! None of the embedded 'println' statements were executed, because this sequence has no terminal operation!")

    val resultsB: List<String> = dataCarMap.asSequence()
        // Note use of rarely seen semi-colon in the predicate expressions  :)
        .filter { println("Inside a sequence filter: [${it.key}]"); it.key.startsWith("J") }
        .map { println("Inside a sequence map: [${it.key}]"); "${it.key} is a ${it.value.color} ${it.value.year} ${it.value.model}." }
        .toList()
    println("Results should contain only cars of people whose name starts with J")
    println(resultsB)

    // Example of a terminal operation that stops sequence processing when it finds the first matching data value.
    // Any elements after the first match is found will not be processed.
    val resultC: Pair<String, DataCar>? = dataCarMap.asSequence()
        .filter { println("Inside a sequence filter: [${it.key}]"); it.value.model == "Ford" }
        // transform from Map.Entry<String,DataCar> to just Pair<String,DataCar>
        .map { Pair(it.key, it.value) }
        .find { it.second.color == "white" }
    println(resultC)

}

package com.jimtough.kotlin.collections

fun main() {

    val immutableSetOfInts = setOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -99, 1111)
    println(immutableSetOfInts)

    // Uses my 'DataCar' class from Maps.kt
    val dataCarMap = mapOf<String, DataCar>(
        "Johnnn's car" to DataCar("grey", "Toyota", 2000),
        "Janey's car" to DataCar("grey", "Ford", 2001),
        "Dougie's car" to DataCar("white", "Ford", 2002),
        "Bruce's car" to DataCar("black", "Ford", 2007),
        "Plopp's car" to DataCar("brown", "Kia", 2003)
    )

    // Use 'filter()' to keep only odd integers
    println("Used 'filter()' to keep only odd numbers: ${immutableSetOfInts.filter { it % 2 != 0 }}")
    // Use 'filter()' to keep only Ford cars
    println(dataCarMap.filter { it.value.model == "Ford" })

    // Use 'map()' to create a new collection that is a transformation of the original collection
    val listOfValuesFromOriginalSetWith10AddedToEachElement: List<Int> = immutableSetOfInts.map { it + 10 }
    println("Used 'map()' to add 10 to each element: $listOfValuesFromOriginalSetWith10AddedToEachElement")

    // Now let's chain together two filter() calls, then a map()
    val results: List<String> = dataCarMap
        // Only keep Ford cars
        .filter { it.value.model == "Ford" }
        // Only keep cars from odd numbered years
        .filter { it.value.year % 2 != 0 }
        // Transform the results into a list of strings
        .map { "${it.key} is a ${it.value.color} ${it.value.year} ${it.value.model}." }
    println("RESULTS")
    results.forEach {println(" - $it")}

    // 'all()' function returns true if all elements pass the predicate lambda, otherwise false
    println(immutableSetOfInts.all { it > 0 })
    // 'all()' function returns true if any one (or more) elements pass the predicate lambda, otherwise false
    println(immutableSetOfInts.any { it > 0 })
    println(immutableSetOfInts.any { it < -9999999999 })
    // 'count()' function returns count of elements that pass the predicate lambda
    println(dataCarMap.count { it.value.model == "Ford" } )

    //-----------------------------------------------------------------

    // Put the cars from the map above into an immutable list so we can experiment with List functions
    val carsList: List<DataCar> = dataCarMap.values.toList()
    // Use 'find()' to find the first car in the list that matches the predicate
    println(carsList.find { it.color == "grey" })
    println(carsList.findLast { it.color == "grey" })
    val carsGroupedByColorMap: Map<String,List<DataCar>> = carsList.groupBy { it.color }
    println(carsGroupedByColorMap)
    val carsGroupedByModelMap: Map<String,List<DataCar>> = carsList.groupBy { it.model }
    println(carsGroupedByModelMap)



}
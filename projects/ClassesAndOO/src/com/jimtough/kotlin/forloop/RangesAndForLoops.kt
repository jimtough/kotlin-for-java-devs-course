package com.jimtough.kotlin.forloop

fun main() {

    // NOTE: Both ends of a range in Kotlin are INCLUSIVE!

    // How to declare ranges in Kotlin
    val intRange = 1..5
    val charRange = 'a'..'z'
    val stringRange = "ABC".."XYZ"
    println("3 in intRange? ${3 in intRange}")
    println("6 in intRange? ${6 in intRange}")
    println("q in charRange? ${'q' in charRange}")
    println("Q in charRange? ${'Q' in charRange}")
    println("ABD in stringRange? ${"ABD" in stringRange}")
    // Hmmmmm... this one gives an unexpected result.
    // Reason is "BBBBBBBBB" is greater than "ABC" and less than "XYZ".
    // Apparently the Kotlin ranges use 'Comparable' to determine what is in or out of the range.
    println("BBBBBBBBB in stringRange? ${"BBBBBBBBB" in stringRange}")
    println("ZZZ in stringRange? ${"ZZZ" in stringRange}")

    // declaring a decreasing range
    val decreasingIntRange = 5.downTo(1)
    println("3 in decreasingIntRange? ${3 in decreasingIntRange}")
    println("0 in decreasingIntRange? ${0 in decreasingIntRange}")

    // declaring a 'step' range - this one will include only even numbers in the range
    val intRangeWithStep2 = (0..20).step(2)
    println("0 in intRangeWithStep2? ${0 in intRangeWithStep2}")
    println("1 in intRangeWithStep2? ${1 in intRangeWithStep2}")
    println("2 in intRangeWithStep2? ${2 in intRangeWithStep2}")
    println("3 in intRangeWithStep2? ${3 in intRangeWithStep2}")
    println("4 in intRangeWithStep2? ${4 in intRangeWithStep2}")

    // Iterating my range of even numbers
    var rangeValuesStrA = ""
    for (n in intRangeWithStep2) {
        rangeValuesStrA += n
        rangeValuesStrA += " "
    }
    println(rangeValuesStrA)

    // Now iterate it in reversed order
    var rangeValuesStrB = ""
    for (n in intRangeWithStep2.reversed()) {
        rangeValuesStrB += n
        rangeValuesStrB += " "
    }
    println(rangeValuesStrB)

    // Now iterate a range that is declared inline in the 'for' loop
    var rangeValuesStrC = ""
    for (i in 1..10) {
        rangeValuesStrC += i
        rangeValuesStrC += " "
    }
    println(rangeValuesStrC)

    // Note that not all range types are iterable. The following does not make sense and will not compile.
    val stRange = "AA".."ZZ"
    //for (s in stRange) {
    //    // do something...
    //}

    // Now iterate a range that is declared inline, and also includes a 'step' inline
    var rangeValuesStrD = ""
    for (i in 4..64 step 4) {
        rangeValuesStrD += i
        rangeValuesStrD += " "
    }
    println(rangeValuesStrD)

    // Now iterate a decreasing range that is declared inline, also with a step defined inline
    var rangeValuesStrE = ""
    for (i in 64 downTo 4 step 4) {
        rangeValuesStrE += i
        rangeValuesStrE += " "
    }
    println(rangeValuesStrE)

    // Now iterate a range that is declared inline in the 'for' loop, but with the end value being EXCLUSIVE
    // The output should end with '9'
    var rangeValuesStrF = ""
    for (i in 1 until 10) {
        rangeValuesStrF += i
        rangeValuesStrF += " "
    }
    println(rangeValuesStrF)

    // Variables can be used in the range definition
    val goodbyeString = "Goodbye, cruel world!"
    var rangeValuesStrG = ""
    for (i in 0 until goodbyeString.indexOf(',')) {
        rangeValuesStrG += goodbyeString[i]
    }
    // output should be "Goodbye"
    println(rangeValuesStrG)


}





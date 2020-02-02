package com.jimtough.kotlin.fileio

import java.io.File
import java.io.InputStreamReader

fun main() {

    //-----------------------------------------------------------------------------------
    // The two operations below work as expected, but are done more like pre-Java 7
    // code, when try-with-resources blocks were not available.
    //-----------------------------------------------------------------------------------
    val isrA: InputStreamReader = File("testfile.txt").reader()
    // This would be a bad idea if reading a very large file
    val allLinesFromFile: List<String> = isrA.readLines()
    isrA.close()
    allLinesFromFile.forEach { println(it) }
    println()
    val isrB: InputStreamReader = File("testfile.txt").reader()
    // This would also be a bad idea if reading a very large file
    val allContentFromFile: String = isrB.readText()
    isrB.close()
    println(allContentFromFile)
    //-----------------------------------------------------------------------------------

    // Now I use the 'use()' method instead. This is similar to Java try-with-resources.
    val allLinesFromFile2: List<String> = File("testfile.txt").reader().use { it.readLines() }
    allLinesFromFile2.forEach { println(it) }

    println()

    // Now with buffered reader
    val allLinesFromFile3: List<String> = File("testfile.txt").bufferedReader().use { it.readLines() }
    allLinesFromFile3.forEach { println(it) }

    println()

    // Now with an extension function of File that takes care of the entire read process
    val allContentFromFile4: String = File("testfile.txt").readText()
    println(allContentFromFile4)

    println()

    // Let's try the 'forEachLine()' function of Reader
    File("testfile.txt").reader().forEachLine { println(it) }

    println()

    // Let's try the 'useLines()' function. This one supplies a sequence, so we must provide a terminal operation.
    File("testfile.txt").reader().useLines { it.forEach { println(it) } }

}

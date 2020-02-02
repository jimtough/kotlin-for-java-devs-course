package com.jimtough.kotlin.fileio

import java.io.File

fun main() {

    // walkToDown() will visit directories before files
    //File("./src").walkTopDown().forEach { println(it) }

    // walkBottomUp() will visit files in leaf nodes first, then directories
    //File("./src").walkBottomUp().forEach { println(it) }


    // We can also apply filter() functions, etc.
    File("./src").walkTopDown()
        // Only want 'normal' file (ignore directories, links, etc.)
        .filter { it.isFile() }
        // Now convert the remaining File results to strings in fully-qualified package name format
        .map { it.toString() }
        .map { it.substring(it.indexOf("com")) }
        .map { it.replace('\\', '.') }
        .forEach { println(it) }

}


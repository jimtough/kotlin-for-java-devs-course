package com.jimtough.kotlin.packagethatdoesnotmatch.the.dir.structure

import com.jimtough.kotlin.imports.internalTopLevelFunction
import com.jimtough.kotlin.inheritance.LaserPrinter
import com.jimtough.kotlin.inheritance.Printer

fun main() {
    println("My package does not match the directory structure! Kotlin allows this!")

    val p: Printer = LaserPrinter("Ploptastic P101", 2)
    p.printModel()

    internalTopLevelFunction("This string comes from Imports.kt")

}
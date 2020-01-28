package com.jimtough.kotlin.declarations

fun main() {

    var number = 20

    // Object reference 'employee1' is immutable, but the object properties are mutable as expected
    val employee1 = Employee("Lynn Jones", 500)
    employee1.name = "Lynn Smith"

    println(employee1)

    val change = 4.22
    // String templates in Kotlin use $varname as the placeholders.
    // You can escape the $ if you want to print that character.
    println("Your change is \$$change")
    println("The value of 'change' is $change")
    println("This is a dollar sign: $")
    // You can evaluate an expression inline in the string template
    println("Your change is worth the same as ${change*100} pennies")
    println("Employee ${employee1.name} has id ${employee1.id}")

    //------------------------------------------------------------------------------------
    // 'Raw strings' - also called 'triple-quoted strings'
    // These do not require escaping of characters that require it in a normal string.
    val exampleWindowsFilePath = """c:\TEMP\some\path\to\file.txt"""
    println(exampleWindowsFilePath)
    // The 'trimMargin()' function will discard the whitespace before the delimiter that
    // you specify. I used the * character below.
    val nurseryRhyme = """Humpty Dumpty sat on a wall.
        *Humpty Dumpty had a great fall.
        *All the king's horses and all the king's men
        *couldn't put Humpty together again.""".trimMargin("*")
    println(nurseryRhyme)
    // String templates also work
    val eggName = "Bumpty"
    val nurseryRhymeWithStringTemplate = """$eggName Dumpty sat on a wall.
        *$eggName Dumpty had a great fall.
        *All the king's horses and all the king's men
        *couldn't put $eggName together again.""".trimMargin("*")
    println(nurseryRhymeWithStringTemplate)
    //------------------------------------------------------------------------------------

}

class Employee(var name: String, val id : Int) {
    override fun toString(): String {
        return "Employee(name=$name, id=$id)"
    }
}

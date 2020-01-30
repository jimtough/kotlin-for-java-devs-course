package com.jimtough.kotlin.lambdas

// NOTE: Lambdas must be inside curly braces in Kotlin

fun main() {

    // 'run' is a utility class you can use to run a lambda when testing code
    run { println("I'm in a lambda!") }

    //-----------------------------------------------------------------------------------------------

    val employees = listOf(
        YetAnotherEmployee("Will", "Smith", 2012),
        YetAnotherEmployee("Wade", "Wilson", 2015),
        YetAnotherEmployee("Magic", "Johnson", 2010),
        YetAnotherEmployee("Dick", "Jones", 2002)
    )

    // Verbose syntax
    //println(employees.minBy({ e: YetAnotherEmployee -> e.startYear }))

    // More concise syntax
    // - Omit the argument type when the compiler is able to infer it.
    // - Omit the lambda argument entirely, when there is only one argument and the compiler can infer the type. Use 'it' to refer to it.
    // - Omit the parentheses for 'minBy'. This is allowed when the lambda is the only parameter in the function call.
    println(employees.minBy { it.startYear } )

    // Another very concise syntax
    // - Instructor calls this 'replacing the lambda with a member reference'
    // - The 'double colon' operator is used to specify the class type and class member to be returned to the 'minBy' method
    println(employees.minBy(YetAnotherEmployee::startYear ))

    //-----------------------------------------------------------------------------------------------

    // Kotlin lambdas are not restricted to only accessing 'final' variables, as they are in Java
    var numVariable = 10
    run {
        numVariable += 15
    }
    // Should print 25
    println(numVariable)

    //-----------------------------------------------------------------------------------------------

    useParameter(employees, 123)

    //-----------------------------------------------------------------------------------------------

    // The double-colon syntax can also be used to pass a top-level function reference.
    // Also note the use of 'run' with parentheses, because we are passing a function reference and not a lambda expression.
    run(::topLevelFunction)

}

fun useParameter(employees: List<YetAnotherEmployee>, num: Int) {
    employees.forEach {
        // The lambda CAN use references to function arguments, as seen below
        println("The employee name: ${it.firstName} | value of 'num': $num")
        // But the lambda CANNOT modify those references. The following line causes a compilation error.
        //num++
    }
}

data class YetAnotherEmployee(val firstName: String, val lastName: String, val startYear: Int)

fun topLevelFunction() = println("This is topLevelFunction!")

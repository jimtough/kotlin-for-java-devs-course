package com.jimtough.kotlin.lambdas

fun main() {

    println(countTo50())
    println(moreConciseCountTo50())
    println(moreConciseCountTo50UsingApply())

    // Playing with apply() and labels
    "Outermost string".apply outermost@ {
        "Middle string".apply middle@ {
            "Innermost string".apply innermost@ {
                println("Who is 'this'?: [$this]")
                println("Who is '$this@innermost'?: [${this@innermost}]")
                println("Who is '$this@middle'?: [${this@middle}]")
                println("Who is '$this@outermost'?: [${this@outermost}]")
            }
        }
    }


}

// Example of a lambda with a receiver
fun countTo50(): String {
    // StringBuilder exists outside of the lambda
    val sb = StringBuilder()
    // 'with' is used to pair the 'sb' object with the lambda that will use it.
    // Note the the lambda is the last argument to 'with', so we are allow to define
    // the lambda outside the 'with' parentheses (for code readability).
    return with(sb) {
        // THIS BLOCK IS ALL LAMBDA CODE
        // Note that inside the lambda code we never need to explicitly use 'sb.' in front of the calls to 'append()'
        //--------------------------------------
        for (i in 1..49) {
            append(i).append(", ")
        }
        append(50)
        toString()
        //--------------------------------------
    }
}

// Oh my! Even MORE concise!
// Because this version of the function can be reduced to a single expression, and return type is implied...
fun moreConciseCountTo50() =
    with(StringBuilder()) {
        for (i in 1..49) {
            append(i).append(", ")
        }
        append(50)
        toString()
    }

fun moreConciseCountTo50UsingApply() =
    // The 'apply()' function will supply the StringBuilder to the lambda function, similar to 'with'.
    // The difference is that 'apply()' returns the original object (the StringBuilder).
    // We finish the function by calling toString() on the StringBuilder so the number string is returned.
    StringBuilder().apply {
        for (i in 1..49) {
            append(i).append(", ")
        }
        append(50)
        toString()
    }.toString()

package com.jimtough.kotlin.enums

fun main() {
    for (e in Department.values()) {
        println(e.getDeptInfo())
    }
}

enum class Department(val fullName: String) {
    HR("Human Resources"),
    IT("Information Technology"),
    ACCT("Accounting"),
    SALES("Sales"),
    SEC("Security");

    // WOW! First time I needed a semi-colon in Kotlin!
    // Must put one after the last enum if you have any functions in the enum class

    fun getDeptInfo() = "The $name enum is for the '$fullName' department"

}
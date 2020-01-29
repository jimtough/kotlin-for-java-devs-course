package com.jimtough.kotlin.anothermodulepackage

import com.jimtough.kotlin.functions.capitalizeFirstAndLast as cfal // Can also use 'as' to alias an extension function!
import com.jimtough.kotlin.enums.Department as DepEnum // Note the use of the 'as' keyword to use an alias for 'Department'
import com.jimtough.kotlin.imports.topLevelFunction
import com.jimtough.kotlin.objectkeyword.Jingleton

fun main() {
    // We can access items from the other module IF the module dependency has been configured in IntelliJ
    topLevelFunction("This string comes from AnotherModuleKotlinFile.kt")
    println(Jingleton.getYearGreeting())
    println(DepEnum.HR.getDeptInfo())
    println("otto".cfal())
}

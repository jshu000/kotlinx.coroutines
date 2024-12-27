// This file was automatically generated from coroutines-basics.md by Knit tool. Do not edit.
package kotlinx.coroutines.guide.exampleBasic01

import kotlinx.coroutines.*

fun main() = runBlocking { // this: CoroutineScope
    var time1= System.currentTimeMillis()
    launch { // launch a new coroutine and continue
        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)

        println("World!     ${currentTimeMillis()-time1}") // print after delay
    }
    println("Hello    ${currentTimeMillis()-time1}") // main coroutine continues while a previous one is delayed
}

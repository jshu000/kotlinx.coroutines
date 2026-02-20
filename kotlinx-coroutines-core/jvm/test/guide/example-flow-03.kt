// This file was automatically generated from flow.md by Knit tool. Do not edit.
package kotlinx.coroutines.guide.exampleFlow03

import kotlinx.coroutines.*

suspend fun simple(): List<Int> {
    delay(1000) // pretend we are doing something asynchronous here
    return listOf(1, 2, 3)
}

fun main() = runBlocking {

    val startTime = System.currentTimeMillis()
    println("Main started at: $startTime ms")

    simple().forEach { value ->
        println(value)
    }

    val endTime = System.currentTimeMillis()
    println("Main ended at: $endTime ms")

    println("Total execution time: ${endTime - startTime} ms")
}

/*
This Kotlin program measures the total execution time of a suspending function using coroutines.
• The simple() function simulates an asynchronous operation by pausing for 1 second using the non-blocking delay(1000) and then returns a list of integers.
• In main(), a coroutine is started using runBlocking to allow calling the suspending function.
• The program records the start time before calling simple() and the end time after processing its result.
• The difference between the start and end timestamps gives the total execution time of the coroutine operation.
*/
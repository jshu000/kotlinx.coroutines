// This file was automatically generated from flow.md by Knit tool. Do not edit.
package kotlinx.coroutines.guide.exampleFlow04

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun simple(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100)
        emit(i)
    }
}

fun main() = runBlocking {

    val startTime = System.currentTimeMillis()
    println("Main started at: ${System.currentTimeMillis() - startTime} ms")

    launch {
        for (k in 1..3) {
            println("I'm not blocked $k at: ${System.currentTimeMillis() - startTime} ms")
            delay(100)
        }
    }

    simple().collect { value ->
        println("$value at: ${System.currentTimeMillis() - startTime} ms")
    }

    val endTime = System.currentTimeMillis()
    println("Main ended at: ${System.currentTimeMillis() - startTime} ms")
    println("Total execution time: ${endTime - startTime} ms")
}

/*
Summary:
• The simple() function creates a Flow that emits integers from 1 to 3 with a delay of 100 milliseconds between each emission.
• The delay() function simulates asynchronous work without blocking the executing thread.
• In main(), runBlocking is used to start a coroutine scope and execute coroutine-based code.
• A separate coroutine is launched concurrently that prints "I'm not blocked" messages every 100 milliseconds to show that the main thread remains unblocked.
• The collect() function is used to consume the emitted values from the Flow sequentially.
• Each println statement displays the elapsed time from the start of execution to observe concurrent behavior.
• The program records the start and end time of execution to measure total runtime of concurrent Flow and coroutine operations.
*/
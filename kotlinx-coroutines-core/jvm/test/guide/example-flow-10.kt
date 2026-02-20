// This file was automatically generated from flow.md by Knit tool. Do not edit.
package kotlinx.coroutines.guide.exampleFlow10

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class Timer {
    companion object {
        val startTime = System.currentTimeMillis()
    }
}

fun numbers(): Flow<Int> = flow {
    try {
        emit(1)
        emit(2)
        println("This line will not execute at: ${System.currentTimeMillis() - Timer.startTime} ms")
        emit(3)
    } finally {
        println("Finally in numbers at: ${System.currentTimeMillis() - Timer.startTime} ms")
    }
}

fun main() = runBlocking<Unit> {

    numbers()
        .take(2)
        .collect { value ->
            println("$value at: ${System.currentTimeMillis() - Timer.startTime} ms")
        }

    println("Done at: ${System.currentTimeMillis() - Timer.startTime} ms")
}

/*
Summary:
• A companion object is used to define a static startTime initialized with the current system time.
• The numbers() function creates a Flow that emits three integer values inside a try-finally block.
• The take(2) operator limits the collection to the first two emitted values.
• After emitting two values, the Flow is cancelled and the remaining emissions are not executed.
• Due to cancellation, the line after the second emit does not run.
• The finally block is executed when the Flow is cancelled, demonstrating proper cleanup.
• Each println statement displays the elapsed time from the static startTime.
• After collection, "Done" is printed along with the elapsed time.
*/

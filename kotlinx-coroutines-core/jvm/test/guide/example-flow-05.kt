// This file was automatically generated from flow.md by Knit tool. Do not edit.
package kotlinx.coroutines.guide.exampleFlow05

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
class Timer {
    companion object {
        val startTime = System.currentTimeMillis()
    }
}

fun simple(): Flow<Int> = flow {
    println("Flow started at: ${System.currentTimeMillis() - Timer.startTime} ms")
    for (i in 1..3) {
        delay(100)
        emit(i)
    }
}

fun main() = runBlocking<Unit> {

    println("Calling simple function... at: ${System.currentTimeMillis() - Timer.startTime} ms")

    val flow = simple()

    println("Calling collect... at: ${System.currentTimeMillis() - Timer.startTime} ms")
    flow.collect { value ->
        println("$value at: ${System.currentTimeMillis() - Timer.startTime} ms")
    }

    println("Calling collect again... at: ${System.currentTimeMillis() - Timer.startTime} ms")
    flow.collect { value ->
        println("$value at: ${System.currentTimeMillis() - Timer.startTime} ms")
    }

    val endTime = System.currentTimeMillis()
    println("Main ended at: ${System.currentTimeMillis() - Timer.startTime} ms")
    println("Total execution time: ${endTime - Timer.startTime} ms")
}

/*
Summary:
• A companion object is used to define a static startTime initialized with the current system time.
• The simple() function creates a Flow that emits integers from 1 to 3 with a delay of 100 milliseconds between each emission.
• A println statement inside the Flow indicates when the Flow starts execution.
• In main(), runBlocking is used to start a coroutine scope.
• The Flow is created once but collected twice using collect().
• Each time collect() is called, the Flow is re-executed from the beginning, demonstrating that Flow is a cold stream.
• Each println statement displays the elapsed time from the static startTime.
• The program records the end time of execution to measure total runtime.
*/
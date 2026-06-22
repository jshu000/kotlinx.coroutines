// This file was automatically generated from flow.md by Knit tool. Do not edit.
package kotlinx.coroutines.guide.exampleFlow13

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class Timer {
    companion object {
        val startTime = System.currentTimeMillis()
    }
}

fun log(msg: String) =
    println("[${Thread.currentThread().name}] $msg at: ${System.currentTimeMillis() - Timer.startTime} ms")

fun simple(): Flow<Int> = flow {
    log("Started simple flow")
    for (i in 1..3) {
        emit(i)
    }
}

fun main() = runBlocking<Unit> {

    simple().collect { value ->
        log("Collected $value")
    }

    log("Done")
}

/*
Summary:
• A companion object defines a static startTime initialized with the current system time.
• The log() function prints the current thread name along with the message and elapsed time.
• The simple() function creates a Flow that emits integers from 1 to 3.
• A log message is printed when the Flow starts execution.
• The collect() function consumes emitted values from the Flow.
• Each collected value is logged along with thread name and elapsed time.
• After completion, a final "Done" message is logged with elapsed time.

Dry Run:
Flow starts → log("Started simple flow")

Emit → 1
Collect → log("Collected 1")

Emit → 2
Collect → log("Collected 2")

Emit → 3
Collect → log("Collected 3")

Finally → log("Done")
*/
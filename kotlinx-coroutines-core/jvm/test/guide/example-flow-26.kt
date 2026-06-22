// This file was automatically generated from flow.md by Knit tool. Do not edit.
package kotlinx.coroutines.guide.exampleFlow26

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class Timer {
    companion object {
        var startTime: Long = 0
    }
}

fun simple(): Flow<Int> = flow {
    for (i in 1..3) {
        println("Emitting $i at: ${System.currentTimeMillis() - Timer.startTime} ms")
        emit(i)
    }
}

fun main() = runBlocking<Unit> {

    Timer.startTime = System.currentTimeMillis()

    try {
        simple().collect { value ->
            println("Collected $value at: ${System.currentTimeMillis() - Timer.startTime} ms")
            check(value <= 1) { "Collected $value" }
        }
    } catch (e: Throwable) {
        println("Caught $e at: ${System.currentTimeMillis() - Timer.startTime} ms")
    }

    println("Done at: ${System.currentTimeMillis() - Timer.startTime} ms")
}

/*
Summary:
• A companion object stores startTime initialized inside runBlocking.
• The simple() function emits integers from 1 to 3 and logs each emission.
• The collect() block prints each collected value.
• The check() function throws an IllegalStateException when the condition fails.
• When value becomes 2, check(value <= 1) fails and throws an exception.
• The Flow is immediately cancelled after the exception.
• The exception is caught in the try-catch block and logged.
• Execution continues after the catch block and prints "Done".

Dry Run:
Emit 1 → Collected 1 → check passes
Emit 2 → Collected 2 → check fails → throws IllegalStateException
Flow cancels immediately
Emit 3 is never executed
Exception caught in catch block
"Done" printed

Final Output Order:
Emitting 1
Collected 1
Emitting 2
Collected 2
Caught java.lang.IllegalStateException: Collected 2
Done
*/
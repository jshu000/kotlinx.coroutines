// This file was automatically generated from flow.md by Knit tool. Do not edit.
package kotlinx.coroutines.guide.exampleFlow29

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

    simple()
        .catch { e ->
            println("Caught $e at: ${System.currentTimeMillis() - Timer.startTime} ms")
        }
        .collect { value ->
            check(value <= 1) { "Collected $value" }
            println("$value at: ${System.currentTimeMillis() - Timer.startTime} ms")
        }

    println("Done at: ${System.currentTimeMillis() - Timer.startTime} ms")
}

/*
Summary:
• A companion object stores startTime initialized inside runBlocking.
• The simple() function emits integers from 1 to 3.
• The catch operator is placed before collect().
• catch() only handles upstream exceptions (from flow builder or intermediate operators before it).
• The check() inside collect() throws an exception when value becomes 2.
• This exception happens downstream (inside collect), so catch() does NOT intercept it.
• The program crashes unless the exception is handled outside the flow chain.

Dry Run:
Emit 1 → passes check → prints 1
Emit 2 → check fails → throws IllegalStateException
Flow is cancelled immediately
Emit 3 never happens
Exception is NOT caught by catch()
Program terminates with exception

Important Concept:
catch() handles upstream exceptions only.
It does NOT catch exceptions thrown inside collect().
*/
// This file was automatically generated from flow.md by Knit tool. Do not edit.
package kotlinx.coroutines.guide.exampleFlow19

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.*

class Timer {
    companion object {
        var startTime: Long = 0
    }
}

fun simple(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100)
        emit(i)
    }
}

fun main() = runBlocking<Unit> {

    Timer.startTime = System.currentTimeMillis()

    val time = measureTimeMillis {
        simple()
            .collectLatest { value ->
                println("Collecting $value at: ${System.currentTimeMillis() - Timer.startTime} ms")
                delay(300)
                println("Done $value at: ${System.currentTimeMillis() - Timer.startTime} ms")
            }
    }

    println("Collected in $time ms at: ${System.currentTimeMillis() - Timer.startTime} ms")
}

/*
Summary:
• A companion object stores startTime initialized inside runBlocking.
• The simple() function emits integers from 1 to 3 with a delay of 100 milliseconds.
• collectLatest() cancels the current collector block when a new value is emitted.
• The collector restarts processing for the latest emitted value.
• The collect block simulates processing time of 300 milliseconds.
• measureTimeMillis calculates total collection time.
• Each println displays elapsed time from Timer.startTime.

Dry Run:
Emit 1 after 100ms → start Collecting 1
Processing 1 (takes 300ms)

Emit 2 after 200ms → cancels processing of 1
Start Collecting 2

Emit 3 after 300ms → cancels processing of 2
Start Collecting 3

Processing 3 completes (300ms)
Done 3 is printed

Total Time ≈ 100 + 100 + 100 + 300 ≈ 600 ms

Values Collected:
Collecting 1 (cancelled)
Collecting 2 (cancelled)
Collecting 3 → Done 3
*/
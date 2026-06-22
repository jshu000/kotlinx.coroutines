// This file was automatically generated from flow.md by Knit tool. Do not edit.
package kotlinx.coroutines.guide.exampleFlow17

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
            .buffer()
            .collect { value ->
                delay(300)
                println("$value at: ${System.currentTimeMillis() - Timer.startTime} ms")
            }
    }

    println("Collected in $time ms at: ${System.currentTimeMillis() - Timer.startTime} ms")
}

/*
Summary:
• A companion object stores startTime which is initialized as the first line inside runBlocking.
• The simple() function creates a Flow that emits integers from 1 to 3 with a delay of 100 milliseconds.
• The buffer() operator allows the Flow to emit values without waiting for the collector to process them.
• This introduces concurrency between emission and collection.
• The collect() block simulates processing time of 300 milliseconds for each emitted value.
• measureTimeMillis calculates the total collection time.
• Each emitted value is printed along with elapsed time from Timer.startTime.

Dry Run:
Emit 1 after 100ms → buffered
Collector starts processing 1 → takes 300ms

Meanwhile:
Emit 2 after 200ms → buffered
Emit 3 after 300ms → buffered

Collector finishes 1 → processes 2 (300ms)
Collector finishes 2 → processes 3 (300ms)

Total Time ≈ 100 + 300 + 300 + 300 ≈ 1000 ms

Without buffer:
Total Time ≈ (100 + 300) * 3 = 1200 ms
*/
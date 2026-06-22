// This file was automatically generated from flow.md by Knit tool. Do not edit.
package kotlinx.coroutines.guide.exampleFlow18

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
            .conflate()
            .collect { value ->
                delay(300)
                println("$value at: ${System.currentTimeMillis() - Timer.startTime} ms")
            }
    }

    println("Collected in $time ms at: ${System.currentTimeMillis() - Timer.startTime} ms")
}

/*
Summary:
• A companion object stores startTime initialized inside runBlocking.
• The simple() function emits integers from 1 to 3 with a delay of 100 milliseconds.
• The conflate() operator skips intermediate emitted values when the collector is slow.
• If a new value is emitted while the collector is still processing the previous one, only the latest value is kept.
• The collect() block simulates processing time of 300 milliseconds for each received value.
• measureTimeMillis calculates total collection time.
• Each printed value includes elapsed time from Timer.startTime.

Dry Run:
Emit 1 after 100ms → Collector starts processing 1 (takes 300ms)

Meanwhile:
Emit 2 after 200ms → replaces previous buffered value
Emit 3 after 300ms → replaces previous buffered value

Collector finishes 1 → receives latest available value → 3
Collector processes 3 (300ms)

Total Time ≈ 100 + 300 + 300 ≈ 700 ms

Values Collected:
1
3
*/
// This file was automatically generated from flow.md by Knit tool. Do not edit.
package kotlinx.coroutines.guide.exampleFlow27

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class Timer {
    companion object {
        var startTime: Long = 0
    }
}

fun simple(): Flow<String> =
    flow {
        for (i in 1..3) {
            println("Emitting $i at: ${System.currentTimeMillis() - Timer.startTime} ms")
            emit(i)
        }
    }
        .map { value ->
            check(value <= 1) { "Crashed on $value" }
            "string $value"
        }

fun main() = runBlocking<Unit> {

    Timer.startTime = System.currentTimeMillis()

    try {
        simple().collect { value ->
            println("$value at: ${System.currentTimeMillis() - Timer.startTime} ms")
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
• The map operator transforms emitted integers into strings.
• Inside map, check(value <= 1) throws an exception when the value becomes greater than 1.
• When value = 2, check fails and throws IllegalStateException.
• Flow is cancelled immediately after the exception is thrown.
• The exception is propagated downstream and caught in the try-catch block in main().
• Execution continues after the catch block and prints "Done".

Dry Run:
Emit 1 → passes check → mapped to "string 1" → collected
Emit 2 → check fails → throws IllegalStateException
Flow cancels immediately
Emit 3 is never executed
Exception caught in catch block
"Done" printed

Final Output Order:
Emitting 1
string 1
Emitting 2
Caught java.lang.IllegalStateException: Crashed on 2
Done
*/
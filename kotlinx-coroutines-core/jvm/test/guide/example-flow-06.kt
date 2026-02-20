// This file was automatically generated from flow.md by Knit tool. Do not edit.
package kotlinx.coroutines.guide.exampleFlow06

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class Timer {
    companion object {
        val startTime = System.currentTimeMillis()
    }
}

fun simple(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100)
        println("Emitting $i at: ${System.currentTimeMillis() - Timer.startTime} ms")
        emit(i)
    }
}

fun main() = runBlocking<Unit> {

    withTimeoutOrNull(250) {
        simple().collect { value ->
            println("$value at: ${System.currentTimeMillis() - Timer.startTime} ms")
        }
    }

    println("Done at: ${System.currentTimeMillis() - Timer.startTime} ms")
}

/*
Summary:
• A companion object is used to define a static startTime initialized with the current system time.
• The simple() function creates a Flow that emits integers from 1 to 3 with a delay of 100 milliseconds between each emission.
• A println statement inside the Flow logs when each value is emitted along with elapsed time.
• In main(), withTimeoutOrNull is used to cancel the Flow collection if it exceeds 250 milliseconds.
• The collect() function consumes emitted values until the timeout occurs.
• Each println statement displays the elapsed time from the static startTime to observe when emissions and collection happen.
• After the timeout or completion, "Done" is printed along with the elapsed time.
*/

// This file was automatically generated from flow.md by Knit tool. Do not edit.
package kotlinx.coroutines.guide.exampleFlow07

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class Timer {
    companion object {
        val startTime = System.currentTimeMillis()
    }
}

fun main() = runBlocking<Unit> {

    (1..3).asFlow().collect { value ->
        println("$value at: ${System.currentTimeMillis() - Timer.startTime} ms")
    }

    println("Done at: ${System.currentTimeMillis() - Timer.startTime} ms")
}

/*
Summary:
• A companion object is used to define a static startTime initialized with the current system time.
• An integer range from 1 to 3 is converted into a Flow using asFlow().
• The collect() function is used to consume emitted values from the Flow sequentially.
• Each println statement displays the emitted value along with elapsed time from the static startTime.
• After collecting all values, "Done" is printed along with the elapsed time.
*/
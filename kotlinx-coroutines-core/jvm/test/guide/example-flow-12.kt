// This file was automatically generated from flow.md by Knit tool. Do not edit.
package kotlinx.coroutines.guide.exampleFlow12

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class Timer {
    companion object {
        val startTime = System.currentTimeMillis()
    }
}

fun main() = runBlocking<Unit> {

    (1..5).asFlow()
        .filter {
            println("Filter $it at: ${System.currentTimeMillis() - Timer.startTime} ms")
            it % 2 == 0
        }
        .map {
            println("Map $it at: ${System.currentTimeMillis() - Timer.startTime} ms")
            "string $it"
        }
        .collect {
            println("Collect $it at: ${System.currentTimeMillis() - Timer.startTime} ms")
        }

    println("Done at: ${System.currentTimeMillis() - Timer.startTime} ms")
}

/*
Summary:
• A companion object defines a static startTime initialized with the current system time.
• The integer range 1 to 5 is converted into a Flow using asFlow().
• The filter operator checks each value and allows only even numbers to pass.
• The map operator transforms the filtered integers into strings.
• The collect operator is a terminal operator that consumes the Flow and prints each transformed value.
• Each println statement logs the elapsed time from the static startTime.
• After completion, "Done" is printed with the total elapsed time.

Dry Run:
Flow emits → 1
Filter 1 → false (filtered out)

Flow emits → 2
Filter 2 → true
Map 2 → "string 2"
Collect → string 2

Flow emits → 3
Filter 3 → false

Flow emits → 4
Filter 4 → true
Map 4 → "string 4"
Collect → string 4

Flow emits → 5
Filter 5 → false

Final Output:
string 2
string 4
*/
// This file was automatically generated from flow.md by Knit tool. Do not edit.
package kotlinx.coroutines.guide.exampleFlow11

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class Timer {
    companion object {
        val startTime = System.currentTimeMillis()
    }
}

fun main() = runBlocking<Unit> {

    val sum = (1..5).asFlow()
        .map { it * it }
        .reduce { a, b -> a + b }

    println("Sum: $sum at: ${System.currentTimeMillis() - Timer.startTime} ms")
    println("Done at: ${System.currentTimeMillis() - Timer.startTime} ms")
}

/*
Summary:
• A companion object is used to define a static startTime initialized with the current system time.
• An integer range from 1 to 5 is converted into a Flow using asFlow().
• The map operator transforms each number into its square.
• The reduce operator accumulates all squared values into a single sum by combining emissions sequentially.
• Reduce is a terminal operator that consumes the Flow and produces a final result.
• The final sum is printed along with the elapsed time from the static startTime.
• After execution, "Done" is printed with the total elapsed time.

Dry Run:
1 → squared = 1
2 → squared = 4
3 → squared = 9
4 → squared = 16
5 → squared = 25

Reduce steps:
Step 1: 1 + 4 = 5
Step 2: 5 + 9 = 14
Step 3: 14 + 16 = 30
Step 4: 30 + 25 = 55

Final Output:
Sum = 55
*/

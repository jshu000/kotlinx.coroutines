// This file was automatically generated from flow.md by Knit tool. Do not edit.
package kotlinx.coroutines.guide.exampleFlow14

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class Timer {
    companion object {
        val startTime = System.currentTimeMillis()
    }
}

fun simple(): Flow<Int> = flow {
    // WRONG way: changing context inside flow builder
    kotlinx.coroutines.withContext(Dispatchers.Default) {
        for (i in 1..3) {
            Thread.sleep(100)
            emit(i)
        }
    }
}

fun main() = runBlocking<Unit> {

    simple().collect { value ->
        println("$value at: ${System.currentTimeMillis() - Timer.startTime} ms")
    }

    println("Done at: ${System.currentTimeMillis() - Timer.startTime} ms")
}

/*
Summary:
• A companion object defines a static startTime initialized with the current system time.
• The simple() function creates a Flow that attempts to switch context using withContext(Dispatchers.Default).
• Inside the switched context, CPU-bound work is simulated using Thread.sleep().
• Emission (emit) happens inside a different coroutine context than the collector.
• The collect() function consumes emitted values from the Flow.
• Each emitted value is printed along with elapsed time from startTime.

IMPORTANT:
• This implementation is incorrect and causes a runtime exception.
• Flow enforces a context preservation rule: emission must happen in the same coroutine context as collection.
• Using withContext inside a flow builder violates this invariant.
• The correct approach is to use flowOn(Dispatchers.Default) instead of withContext.

Dry Run (Logical Execution):
Flow collected in runBlocking context.
Flow attempts to switch to Dispatchers.Default.
Emit happens in Default dispatcher.
Collector is in BlockingCoroutine.
Context mismatch detected.
Runtime throws:
IllegalStateException: Flow invariant is violated.
*/
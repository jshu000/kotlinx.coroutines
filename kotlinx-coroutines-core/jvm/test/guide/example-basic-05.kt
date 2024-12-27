// This file was automatically generated from coroutines-basics.md by Knit tool. Do not edit.
package kotlinx.coroutines.guide.exampleBasic05

import kotlinx.coroutines.*

fun main() = runBlocking {
    var time1= System.currentTimeMillis()
    println("start time ${currentTimeMillis()-time1}")
    val job = launch { // launch a new coroutine and keep a reference to its Job
        delay(1000L)
        println("World!     ${currentTimeMillis()-time1}")
    }
    println("Hello   ${currentTimeMillis()-time1}")
    job.join() // wait until child coroutine completes
    println("Done   ${currentTimeMillis()-time1}")
}

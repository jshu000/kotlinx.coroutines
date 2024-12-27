// This file was automatically generated from coroutines-basics.md by Knit tool. Do not edit.
package kotlinx.coroutines.guide.exampleBasic04

import kotlinx.coroutines.*

// Sequentially executes doWorld followed by "Done"
fun main() = runBlocking {
    var time1= System.currentTimeMillis()
    println("start time ${currentTimeMillis()-time1}")
    doWorld(time1)
    println("Done  ${currentTimeMillis()-time1}")
}

// Concurrently executes both sections
suspend fun doWorld(time1: Long) = coroutineScope { // this: CoroutineScope
    launch {
        delay(2000L)
        println("World 2   ${currentTimeMillis() - time1}\")")
    }
    launch {
        delay(1000L)
        println("World 1  ${currentTimeMillis()-time1}")
    }
    println("Hello   ${currentTimeMillis()-time1}")
}

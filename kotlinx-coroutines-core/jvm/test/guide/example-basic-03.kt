// This file was automatically generated from coroutines-basics.md by Knit tool. Do not edit.
package kotlinx.coroutines.guide.exampleBasic03

import kotlinx.coroutines.*

fun main() = runBlocking {
    var time1= System.currentTimeMillis()
    println("start time ${currentTimeMillis()-time1}   ${Thread.currentThread().name}")
    doWorld(time1)
    println("end time ${currentTimeMillis()-time1}  ${Thread.currentThread().name}")
}

suspend fun doWorld(time1:Long) = coroutineScope {  // this: CoroutineScope
    launch {
        delay(1000L)
        println("World! ${currentTimeMillis()-time1}   ${Thread.currentThread().name}")
    }
    println("Hello  ${currentTimeMillis()-time1}   ${Thread.currentThread().name}")
}

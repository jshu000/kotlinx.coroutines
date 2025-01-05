// This file was automatically generated from coroutines-basics.md by Knit tool. Do not edit.
package kotlinx.coroutines.guide.exampleBasic02

import kotlinx.coroutines.*

fun main() = runBlocking { // this: CoroutineScope
    var time1= System.currentTimeMillis()
    println("Starting  ${currentTimeMillis()-time1}   ${Thread.currentThread().name}")
    launch { doWorld(time1) }
    println("Hello  ${currentTimeMillis()-time1}   ${Thread.currentThread().name}")
}

// this is your first suspending function
suspend fun doWorld(time1:Long) {
    delay(1000L)
    println("World!  ${currentTimeMillis() - time1}   ${Thread.currentThread().name}")
}

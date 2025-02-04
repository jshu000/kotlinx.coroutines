// This file was automatically generated from coroutines-basics.md by Knit tool. Do not edit.
package kotlinx.coroutines.guide.exampleBasic06

import kotlinx.coroutines.*

fun main() = runBlocking {
    var time1= System.currentTimeMillis()
    println("start time ${currentTimeMillis()-time1}   ${Thread.currentThread().name}")
    var i=0
    repeat(50_000) { // launch a lot of coroutines
        launch {
            delay(5000L)
            println(". $i  ${currentTimeMillis()-time1}   ${Thread.currentThread().name}")
            i++
        }
    }
}

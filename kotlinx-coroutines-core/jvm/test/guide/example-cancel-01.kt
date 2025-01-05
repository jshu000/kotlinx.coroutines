// This file was automatically generated from cancellation-and-timeouts.md by Knit tool. Do not edit.
package kotlinx.coroutines.guide.exampleCancel01

import kotlinx.coroutines.*

fun main() = runBlocking {
    var time1= System.currentTimeMillis()
    println("start time -${currentTimeMillis()-time1}")
    val job = launch {
        var i = 0
        while(i <100) {
            println("job: I'm sleeping $i ... time -${currentTimeMillis()-time1}")
            i++
            delay(500L)
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!  time -${currentTimeMillis()-time1}")
    job.cancel() // cancels the job
    job.join() // waits for job's completion 
    println("main: Now I can quit. time -${currentTimeMillis()-time1}")
}

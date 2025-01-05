// This file was automatically generated from cancellation-and-timeouts.md by Knit tool. Do not edit.
package kotlinx.coroutines.guide.exampleCancel02

import kotlinx.coroutines.*

fun main() = runBlocking {
    var time1= System.currentTimeMillis()
    println("start time -${currentTimeMillis()-time1}")
    val startTime = currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (i < 5) { // computation loop, just wastes CPU
            // print a message twice a second
            if (currentTimeMillis() >= nextPrintTime) {
                println("job: I'm sleeping ${i++} ... time -${currentTimeMillis()-time1}")
                nextPrintTime += 500L
            }
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!  time -${currentTimeMillis()-time1}")
    //delay is cancellable suspend function.
    //Without delay if you want to cancel. It cannot able to cancel.
    job.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.  time -${currentTimeMillis()-time1}")
}

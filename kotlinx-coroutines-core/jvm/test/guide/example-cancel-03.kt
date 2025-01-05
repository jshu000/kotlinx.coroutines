// This file was automatically generated from cancellation-and-timeouts.md by Knit tool. Do not edit.
package kotlinx.coroutines.guide.exampleCancel03

import kotlinx.coroutines.*

fun main() = runBlocking {
    var time1= System.currentTimeMillis()
    println("start time -${System.currentTimeMillis()-time1}")
    val job = launch(Dispatchers.Default) {
        repeat(5) { i ->
            try {
                // print a message twice a second
                println("job: I'm sleeping $i ... time -${System.currentTimeMillis()-time1}")
                delay(500)
            } catch (e: Exception) {
                // log the exception
                println(e)
            }
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!  time -${System.currentTimeMillis()-time1}")
    job.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.  time -${System.currentTimeMillis()-time1}")
}

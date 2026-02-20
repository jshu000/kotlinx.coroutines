// This file was automatically generated from flow.md by Knit tool. Do not edit.
package kotlinx.coroutines.guide.exampleFlow08

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class Timer {
    companion object {
        val startTime = System.currentTimeMillis()
    }
}

suspend fun performRequest(request: Int): String {
    delay(1000)
    return "response $request"
}

fun main() = runBlocking<Unit> {

    (1..3).asFlow()
        .map { request -> performRequest(request) }
        .collect { response ->
            println("$response at: ${System.currentTimeMillis() - Timer.startTime} ms")
        }

    println("Done at: ${System.currentTimeMillis() - Timer.startTime} ms")
}

/*
Summary:
• A companion object is used to define a static startTime initialized with the current system time.
• The performRequest() suspending function simulates a long-running asynchronous operation using delay.
• An integer range from 1 to 3 is converted into a Flow representing multiple requests.
• Each request is processed sequentially using the map operator to call performRequest().
• The collect() function consumes the responses emitted by the Flow.
• Each println statement displays the response along with elapsed time from the static startTime.
• After all responses are collected, "Done" is printed along with the elapsed time.
*/

// This file was automatically generated from flow.md by Knit tool. Do not edit.
package kotlinx.coroutines.guide.exampleFlow02

fun simple(): Sequence<Int> = sequence { // sequence builder   //This is lazy execution.
    for (i in 1..3) {
        Thread.sleep(2000) // pretend we are computing it
        yield(i) // yield next value
    }
}

fun main() {
    simple().forEach { value -> println(value) } 
}


/*
This Kotlin program defines a function simple() that returns a lazy Sequence<Int> using the sequence {} builder.
•	Inside the sequence, numbers from 1 to 3 are generated.
•	Before producing each number, the program pauses for 100 milliseconds using Thread.sleep(100) to simulate a time-consuming computation.
•	The yield(i) statement emits one value at a time and suspends execution of the sequence until the next value is requested.

In main(), the sequence is consumed using forEach, which:
•	Requests each value one by one,
•	Resumes execution of the sequence from where it last paused,
•	Prints each emitted number to the console.

Because sequences are lazily evaluated, the loop inside simple() does not run all at once. Instead, each element is computed and returned only when it is needed during iteration.*/

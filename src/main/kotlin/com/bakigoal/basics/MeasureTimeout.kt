package com.bakigoal.basics

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val time = measureTimeMillis {
        println("The answer is ${concurrentSum()}")
    }
    println("Completed in $time ms")
}

private suspend fun concurrentSum() = coroutineScope {
    val one = async { doSomethingUsefulOne() }
    val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo() }
    two.start()
    val three = doSomethingUsefulThree()
    one.await() + two.await() + three
}

suspend fun doSomethingUsefulOne(): Int {
    delay(1000L) // pretend we are doing something useful here
    return 13
}

suspend fun doSomethingUsefulTwo(): Int {
    delay(1000L) // pretend we are doing something useful here, too
    return 29
}

suspend fun doSomethingUsefulThree(): Int {
    delay(1000L) // pretend we are doing something useful here
    return 33
}
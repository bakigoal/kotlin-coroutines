package com.bakigoal.basics

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = doSomethingUsefulOne()
        val two = async { doSomethingUsefulTwo() }
        val three = async(start = CoroutineStart.LAZY) { doSomethingUsefulThree() }
        three.start()
        println("The answer is ${one + two.await() + three.await()}")
    }
    println("Completed in $time ms")
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
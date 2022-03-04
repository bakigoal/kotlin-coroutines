package com.bakigoal.basics

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    doWorld()
    println("Done")
}

/**
 * runBlocking and coroutineScope builders may look similar
 * because they both wait for their body and all its children to complete.
 * The main difference is that the runBlocking method blocks the current thread for waiting,
 * while coroutineScope just suspends, releasing the underlying thread for other usages.
 * Because of that difference, runBlocking is a regular function and coroutineScope is a suspending function.
 */
private suspend fun doWorld() = coroutineScope {
    launch {
        delay(2000L)
        println("World 2")
    }
    launch {
        delay(1000L)
        println("World 1")
    }
    println("Hello")
}
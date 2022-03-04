package com.bakigoal.basics

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    doWorld()
}

private suspend fun doWorld() = coroutineScope {
    val job = launch {
        delay(1000L)
        println("World")
    }
    println("Hello")
    job.join()
    println("Done")
}
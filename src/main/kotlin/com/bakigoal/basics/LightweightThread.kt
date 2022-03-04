package com.bakigoal.basics

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

fun main() {
    lightweightCoroutines()
    // heavyJavaThreads()  // OutOfMemoryError
}

private fun lightweightCoroutines() {
    runBlocking {
        repeat(100_000) {
            launch {
                delay(5000L)
                println(".")
            }
        }
    }
}

fun heavyJavaThreads() {
    repeat(100_000) {
        thread {
            Thread.sleep(5000L)
            println(".")
        }
    }
}
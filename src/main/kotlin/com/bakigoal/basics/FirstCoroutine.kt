package com.bakigoal.basics

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.DurationUnit
import kotlin.time.toDuration

fun main() = runBlocking {      // this: CoroutineScope
    launch {                // launch a new coroutine and continue
        doWorld()
    }
    println("Hello")        // main coroutine continues while a previous one is delayed
}

private suspend fun doWorld() {
    // delay is a special suspending function.
    // It suspends the coroutine for a specific time.
    // Suspending a coroutine does not block the underlying thread,
    // but allows other coroutines to run and use the underlying thread for their code.
    delay(1.toDuration(DurationUnit.SECONDS))
    println("World!")        // print after delay
}
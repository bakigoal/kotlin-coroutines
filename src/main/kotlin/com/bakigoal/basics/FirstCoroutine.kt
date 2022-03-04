package com.bakigoal.basics

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.DurationUnit
import kotlin.time.toDuration

fun main() {
    runBlocking {      // this: CoroutineScope
        launch {       // launch a new coroutine and continue
            delay(1.toDuration(DurationUnit.SECONDS))    // non-blocking delay for 1 second
            println("World!")        // print after delay
        }
        println("Hello")        // main coroutine continues while a previous one is delayed
    }
}
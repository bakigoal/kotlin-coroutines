package com.bakigoal.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun simpleBlock(): Sequence<Int> = sequence { // sequence builder
    for (i in 1..5) {
        Thread.sleep(1000) // pretend we are computing it
        yield(i) // yield next value
    }
}

suspend fun simpleAsync(): Flow<Int> = flow {
    for (i in 1..5) {
        delay(1000) // pretend we are doing something asynchronous here
        emit(i) // yield next value
    }
}

fun main() = runBlocking {
    launch {
        for (k in 1..3) {
            println("I'm not blocked $k")
            delay(1000)
        }
    }
    simpleBlock().forEach { println("Seq $it") }
    simpleAsync().collect { println("Flow $it") }
}
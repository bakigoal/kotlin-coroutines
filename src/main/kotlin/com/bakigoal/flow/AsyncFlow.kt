package com.bakigoal.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun simple1(): Sequence<Int> = sequence { // sequence builder
    for (i in 1..5) {
        Thread.sleep(1000) // pretend we are computing it
        yield(i) // yield next value
    }
}

suspend fun simple(): Flow<Int> = flow {
    for (i in 1..5) {
        delay(1000) // pretend we are doing something asynchronous here
        emit(i) // yield next value
    }
}

fun main() = runBlocking {
    simple1().forEach { println("Seq $it") }
    simple().collect { println("Flow $it") }
}
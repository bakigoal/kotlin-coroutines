package com.bakigoal.basics

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val deferred = (1..3).map {
        async {
            delay(1000L * it)
            println("Loading $it")
            it
        }
    }
    println("waiting...")
    println(deferred.awaitAll().sum())
}
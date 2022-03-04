package com.bakigoal.basics

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val deferred = async {
        loadData()
    }
    println("waiting...")
    println(deferred.await())
}

suspend fun loadData(): Int {
    delay(1000L)
    println("loading...")
    delay(3000L)
    println("loaded!")
    return 42
}
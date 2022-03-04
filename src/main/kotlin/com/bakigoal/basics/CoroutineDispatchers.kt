package com.bakigoal.basics

import kotlinx.coroutines.*

@DelicateCoroutinesApi
fun main() = runBlocking {
    launch { // context of the parent, main runBlocking coroutine
        log("main runBlocking 1")
        delay(100)
        log("main runBlocking 2")
    }
    launch(Dispatchers.Unconfined) { // not confined -- will work with main thread
        log("Unconfined 1")
        delay(200)
        log("Unconfined 2")
    }
    launch(Dispatchers.Default) { // will get dispatched to DefaultDispatcher
        delay(300)
        log("Default")
    }
    launch(newSingleThreadContext("MyOwnThread")) { // will get its own new thread
        delay(400)
        log("MyOwnThread")
    }
    delay(600)
    println()
}

private fun log(message: String) {
    println("[ ${Thread.currentThread().name} ]: $message")
}
package com.bakigoal.basics

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val channel = Channel<String>()

    launch() {
        channel.send("A1")
        channel.send("A2")
        log("A - done")
    }

    launch {
        channel.send("B1")
        log("B - done")
    }

    launch {
        repeat(3) {
            log(channel.receive())
        }
    }

}

fun log(message: Any?) {
    println("[${Thread.currentThread().name}] $message")
}
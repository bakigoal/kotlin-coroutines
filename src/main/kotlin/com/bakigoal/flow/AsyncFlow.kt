package com.bakigoal.flow

fun simple(): Sequence<Int> = sequence { // sequence builder
    for (i in 1..5) {
        Thread.sleep(500) // pretend we are computing it
        yield(i) // yield next value
    }
}

fun main() {
    simple().forEach { value -> println(value) }
}
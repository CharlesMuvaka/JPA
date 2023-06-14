package com.example.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {// A coroutine scope builder
    launch {// starts a new coroutine while the other one is still running
        delay(1000L) // delays the coroutine with the specified milliseconds
        println("This is supposed to be printed last after a delay of one second")
    }
    println("I will be printed first, lets check and see.")
}
package com.example.kotlingame

import kotlinx.coroutines.*
import java.lang.System.exit


/*
        * Made By DuckBeat
        * Start: 2019.04.09
        * Use_LN: Kotlin
        * Subject: Train Game
 */
fun main() = runBlocking{
    val addit = Addit()
    var user = User()                                                  //default setting
    while(true) {
        println("Train Game\n\n1. New Start\n2. Load Game\n3. Exit\n")
        when(addit.sc.nextLine()){
            "1" -> City().Menu(user)
            "2" -> {
                user = addit.Load()
                println("Game Start")
                delay(500L)
                City().Menu(user)
            }
            "3" -> exit(0)
            else -> println("Your input is Wrong")
        }
        addit.cls()
    }
}
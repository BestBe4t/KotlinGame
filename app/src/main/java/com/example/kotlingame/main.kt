/*
        * Made By DuckBill
        * Start: 2019.04.09
        * Use_LN: Kotlin
        * Subject: Train Game
*/

package com.example.kotlingame

import kotlinx.coroutines.*
import java.lang.System.exit

fun main() = runBlocking{
    val addit = Addit()
    var user_info:User

    while(true) {
        println("Train Game\n\n1. New Start\n2. Load Game\n3. Exit\n")
        when(addit.sc.nextLine()){
            "1" -> {
                user_info=addit.UserSet(arrayOf(10000, 1, 1))
                City().Menu(user_info)
            }
            "2" -> {
                user_info = addit.Load()
                println("Game Start")
                delay(500L)
                City().Menu(user_info)
            }
            "3" -> exit(0)
            else -> println("Your input is Wrong")
        }
        addit.cls()
    }
}
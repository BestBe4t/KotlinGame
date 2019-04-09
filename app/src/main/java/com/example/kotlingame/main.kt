package com.example.kotlingame

import java.io.File
import java.lang.System.exit

/*
        * Made By DuckBeat
        * Start: 2019.04.09
        * Use_LN: Kotlin
        * Subject: Train Game
 */
fun main(argv:Array<String>){
    val addit = Addit()
    while(true) {
        println("Train Game\n\n1. Start\n2. Load\n3. Exit\n")
        when(addit.sc.nextLine()){
            "1" -> println("Start Game")
            "2" -> {
                println("Game Loading")
                addit.main_act.UserSet(arrayOf("0", "1", "2", "장조림", "3"))
            }
            "3" -> exit(0)
            else -> println("Your input is Wrong")
        }
        addit.cls()
    }
}
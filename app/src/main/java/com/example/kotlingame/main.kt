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
    var user = Addit.Companion.User
    while(true) {
        println("Train Game\n\n1. Start\n2. Load\n3. Exit\n")
        when(Addit.sc.nextLine()){
            "1" -> {
                File("savefile.md").writeText("10\n0\n1\n2\n3")
                println("Game Start")
            }
            "2" -> {
                println("Game Loading")
                val save=File("savefile.md").readLines()
                user=addit.UserSet(arrayOf(save[0], save[1], save[2], save[3], save[4]))
                println("${user.city}, ${user.item[0]}, ${user.item[1]}, ${user.money}, ${user.train}")
            }
            "3" -> exit(0)
            else -> println("Your input is Wrong")
        }
        //addit.cls()
    }
}
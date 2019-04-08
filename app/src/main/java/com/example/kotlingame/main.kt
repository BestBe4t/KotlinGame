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
        println("기차 게임\n\n1. 새로하기\n2. 불러오기\n3. 종료\n")
        when(addit.sc.nextLine()){
            "1" -> println("게임시작")
            "2" -> {
                println("불러오기")
                addit.UserSet(arrayOf("0", "1", "2", "장조림", "3"))
            }
            "3" -> exit(0)
            else -> println("잘못 입력하였습니다.")
        }
        addit.cls()
    }
}
package com.example.kotlingame

import java.util.*

class Addit{
    object User{
        var money=0
        var train=0
        var city=0
        var item:Array<String> = arrayOf("", "")
    }
    val sc:Scanner = Scanner(System.`in`)                                                                               //Scanner temp
    fun cls(){                                                                                                          //Clear Console
        for(i in 0..75) println("\n")
    }
    fun UserSet(user:Array<String>){
        User.money=user.get(0).toInt()
        User.train=user.get(1).toInt()
        User.city=user.get(2).toInt()
        User.item[0]=user.get(3)
        User.item[1]=user.get(4)

        println("money: ${User.money}, train: ${User.train}, city: ${User.city}, item_name: ${User.item[0]}, item_value: ${User.item[1]}")
    }
}
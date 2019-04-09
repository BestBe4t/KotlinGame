package com.example.kotlingame

import java.util.*

open class Addit{
    companion object {
        object User{                                                                                                    //object user
            var money=0
            var train=0
            var city=0
            var item:Array<String> = arrayOf("", "")
        }
        val sc:Scanner = Scanner(System.`in`)                                                                           //Scanner temp
    }
    fun cls(){                                                                                                          //Clear Console
        for(i in 0..75) println("\n")
    }
    fun UserSet(user: Array<String>):Companion.User {
        Addit.Companion.User.money = user.get(0).toInt()
        Addit.Companion.User.train = user.get(1).toInt()
        Addit.Companion.User.city = user.get(2).toInt()
        Addit.Companion.User.item[0] = user.get(3)
        Addit.Companion.User.item[1] = user.get(4)

        return Addit.Companion.User
    }
}

class city : Addit(){                                                                                                   //city_page fun & var
    fun Menu(user: Addit.Companion.User){
        println("City Name : ${user.city}, Money : ${user.money}")
        println("1. Buy, 2. Sell, 3. Upgrade, 4. Move Or Change Train, 5. Save & Exit")
        when(Addit.sc.nextLine()){
            "1"->println("Buy product")
            "2"->println("Sell product")
            "3"->println("Upgrade mod")
            "4"->Moving().menu(user)
            "5"->println("Save & Exit")
            else -> println("Your input is Wrong")
        }
    }
}

class Moving : Addit(){                                                                                                 //moving_page fun & var
    fun menu(user: Addit.Companion.User) {                                                                              //moving page activate all train's are move
        println("All Train's are moving")
        println("1. Train's Progress, 2. Save & Exit")
        when(Addit.sc.nextLine()){
            "1"->println("Train's Progress")
            "2"->println("Save & Exit")
            else -> println("Your input is Wrong")
        }
    }
}

class main_act : Addit(){                                                                                               //main_page fun & var

}
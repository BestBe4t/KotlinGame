package com.example.kotlingame

import java.util.*

class Addit{
    companion object {
        object User{                                                                                                        //object user
            var money=0
            var train=0
            var city=0
            var item:Array<String> = arrayOf("", "")
        }
        val sc:Scanner = Scanner(System.`in`)                                                                               //Scanner temp
        fun cls(){                                                                                                          //Clear Console
            for(i in 0..75) println("\n")
        }
    }
    class main_act {                                                                                                        //main_page fun & var
        fun UserSet(user: Array<String>) {
            User.money = user.get(0).toInt()
            User.train = user.get(1).toInt()
            User.city = user.get(2).toInt()
            User.item[0] = user.get(3)
            User.item[1] = user.get(4)

            println("money: ${User.money}, train: ${User.train}, city: ${User.city}, item_name: ${User.item[0]}, item_value: ${User.item[1]}")
        }
    }
    class city{                                                                                                             //city_page fun & var
        fun Menu(user:User){
            println("City Name : ${user.city}, Money : ${user.money}")
            println("1. Buy, 2. Sell, 3. Upgrade, 4. Save & Exit")
            when(sc.nextline()){
                "1"->println("Buy product")
                "2"->println("Sell product")
                "3"->println("Upgrade mod")
                "4"->println("Save & Exit")
                else -> println("Your input is Wrong")
            }
        }
    }
    class Moving{                                                                                                           //moving_page fun & var
        fun menu(user:User) {                                                                                               //moving page activate all train's are move
            println("All Train's are moving")
            println("1. Train's Progress, 2. Save & Exit")
            when(sc.nextLine()){
                "1"->println("Train's Progress")
                "2"->println("Save & Exit")
                else -> println("Your input is Wrong")
            }
        }
    }
}
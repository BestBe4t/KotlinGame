/*
        * Made By DuckBill
        * Start: 2019.04.09
        * Use_LN: Kotlin
        * Subject: Train Game
*/

package com.example.kotlingame

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.Exception
import java.lang.NullPointerException
import java.util.*
import kotlin.system.exitProcess

class City:Addit(){                                                                                                     //city_page fun & var
    fun Menu(user:User){
        var User = user
        while(true) {
            println("City Name : ${User.City}, Money : ${User.Money}")
            println("------------Have Products-------------")
            println("|         Name         | Value |Count|")
            if (!User.link.isEmpty()) {
                var count=0
                while(User.link.nodeAtIndex(count)!=null) {
                    println(
                        "|    " + User.link.nodeAtIndex(count)!!.Name + "    | " +
                                User.link.nodeAtIndex(count)!!.Value + " |  " +
                                User.link.nodeAtIndex(count)!!.Count + "  |"
                    )
                    count++
                }
            }
            println("--------------------------------------")
            println("1. Buy, 2. Sell, 3. Upgrade, 4. Move Or Change Train, 5. Save & Exit")
            when (sc.nextLine()) {
                "1" -> User=Buy(User)
                "2" -> User=Sell(User)
                "3" -> User=Upgrade(User)
                "4" -> Moving().menu(User)
                "5" -> Save(User)
                else -> println("Your input is Wrong")
            }
            cls()
        }
    }

    fun Buy(user:User):User{                                                                                            //buy product
        var Item=Item_Menu(0, user.City)                                                                          //Item_Menu return (item NB)*100+(Item CNT)
        val Item_Name="city"+user.City+" NB"+Item/100+" item"
        var Item_val:Int
        val Item_CNT=Item%100
        when (user.City){
            1 -> Item_val = city1[Item/100].Value
            2 -> Item_val = city2[Item/100].Value
            3 -> Item_val = city3[Item/100].Value
            4 -> Item_val = city4[Item/100].Value
            else -> Item_val=0
        }

        runBlocking {
            if (Item_val * Item_CNT > user.Money) {
                println("Money isn't enough")
                delay(500L)
            } else {
                user.link.append(Item_Name, Item_val, Item_CNT)
                user.Money -= Item_val * Item_CNT
            }
        }
        return user
    }

    fun Sell(user:User):User{
        println("Sell product")
        var Item=Item_Menu(1, user_info.City)
        return user
    }

    fun Upgrade(user:User):User {
        var item=0
        loop@ while(true) {
            println("Upgrade mode\nWhich one do you want upgrade? 1. Train, 2. City, 3.exit")
            when (sc.nextLine()) {
                "1" -> {
                    item=Item_Menu(2, user_info.City)
                }
                "2" -> {
                    item=Item_Menu(3, user_info.City)
                }
                "3" -> break@loop
                else -> {
                    println("Wrong Input")
                }
            }
            if(item!=0){
                break@loop
            }
        }
        return user
    }
    fun Item_Menu(Kind:Int, City:Int):Int{
        when(Kind){
            0->{
                while (true) {
                    println("Buy Product")
                    println("|      Product     |  Price | Stock |")
                    when(City){
                        1->{
                            for (i in 0..4){
                                println("|  ${city1[i].Name}  |  ${city1[i].Value}  |  ${city1[i].Count}  |")
                            }
                        }
                        2-> {
                            for (i in 0..4) {
                                println("|  ${city2[i].Name}  |  ${city2[i].Value}  |  ${city2[i].Count}  |")
                            }
                        }
                        3-> {
                            for (i in 0..4) {
                                println("|  ${city3[i].Name}  |  ${city3[i].Value}  |  ${city3[i].Count}  |")
                            }
                        }
                        4-> {
                            for (i in 0..4) {
                                println("|  ${city4[i].Name}  |  ${city4[i].Value}  |  ${city4[i].Count}  |")
                            }
                        }
                    }
                    println("Input Product's Number(Don't want buy some. Plz input 6)")
                    try{
                        when(val NB=sc.nextInt()){
                            1, 2, 3, 4, 5 -> {
                                while (true) {
                                    print("Plz input count : ")
                                    val CO = sc.nextInt()
                                    if (CO > 50) {
                                        println("Count Error")
                                    }else return (NB*100)+CO
                                }
                            }
                            6-> return 0
                            else -> println("Input Wrong text")
                        }
                    }catch (e: InputMismatchException){
                        println("Input Error")
                    }
                }
                return 0
            }
            1->{
                println("Sell Product")
                return 0
            }
            2->{
                println("Train Upgrade")
                return 0
            }
            3->{
                println("City Upgrade")
                return 0
            }
            else->{
                println("Menu ERROR")
                exitProcess(0)
            }
        }
    }
}
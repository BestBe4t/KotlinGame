/*
        * Made By DuckBill
        * Start: 2019.04.09
        * Use_LN: Kotlin
        * Subject: Train Game
*/

package com.example.kotlingame

import java.lang.Exception
import java.util.*
import kotlin.system.exitProcess

class City:Addit(){                                                                                                     //city_page fun & var
    var item:Item = Item()

    fun Menu(user:User){
        while(true) {
            item= if (user.Item != null) user.Item!! else Item("", 0, 0)
            println("City Name : ${user.City}, Money : ${user.Money}")
            println("------------Have Products-------------")
            while(true) {
                if(item.Name=="" && item.Count == 0) break
                println("${item.Name}, ${item.Count}")
                if (item.NextItem == null) break
                else item = user.Item?.NextItem!!
            }
            println("--------------------------------------")
            println("1. Buy, 2. Sell, 3. Upgrade, 4. Move Or Change Train, 5. Save & Exit")
            when (sc.nextLine()) {
                "1" -> user=Buy(user)
                "2" -> user=Sell(user)
                "3" -> user=Upgrade(user)
                "4" -> Moving().menu(user)
                "5" -> Save(user)
                else -> println("Your input is Wrong")
            }
            cls()
        }
    }

    fun Buy(user:User):User{                                                                                                          //buy product
        println("Buy product")
        var Item=Item_Menu(0, user.City)                                                                    //Item_Menu return (item NB)*100+(Item CNT)
        val Item_Name="city"+user.City+" NB"+Item/100+" item"
        val Item_CNT=Item%100

        if(Item_CNT>50){
            println("Count Maximum Over..")
        }else if(city1[(Item/100-1)].Value*Item_CNT>user.Money){
            println("Money isn't enough")
        }else{
            var New_Item:Item=Item(Item_Name, (city1[(Item/100-1)].Value*1.4).toInt(), Item_CNT)
            user_info=UserSet(arrayOf(NoVal, user.Money-city1[(Item/100-1)].Value*Item_CNT, NoVal))
            if(user.Item == null) {
                user.Item=New_Item
                last_item===user.Item!!.NextItem
            }
            else {
                var fitem:Item=user.Item!!
                while (true){
                    if(user.Item==last_item) user.Item!!.NextItem=New_Item
                    else user.Item=user.Item!!.NextItem
                }
                last_item=user.Item
                user.Item=fitem
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
        while(true) {
            println("Upgrade mod\nWhich one do you want upgrade? 1. Train, 2. City")
            when (sc.nextLine()) {
                "1" -> {
                    item=Item_Menu(2, user_info.City)
                }
                "2" -> {
                    item=Item_Menu(3, user_info.City)
                }
                else -> {
                    println("Wrong Input")
                }
            }
            if(item!=0){
                break
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
                                println("${city4[i].Name}  |  ${city4[i].Value}  |  ${city4[i].Count}")
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
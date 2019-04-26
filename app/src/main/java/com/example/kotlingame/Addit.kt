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
import java.io.File
import java.io.FileNotFoundException
import java.util.*
import java.security.MessageDigest
import java.math.BigInteger
import kotlin.system.exitProcess

data class User(                                                                                                        //object user
    var Money:Int=0,
    var Train:Int=0,
    var City:Int=0,
    var Item:Item?=null
)

data class Item(
    var Name:String="",
    var Value:Int=0,
    var Count:Int=0,
    var NextItem:Item?=null
)

open class Addit{                                                                                                       //integrated fun & val
    var user_info:User = User()                                                                                         //user info
    val sc: Scanner = Scanner(System.`in`)                                                                              //Scanner temp
    var last_item:Item? = Item()                                                                                        //Latest Item
    val NoVal=-1                                                                                                        //Hasn't Value

    val city1:Array<Item> = arrayOf(
        Item("city1 NB1 Item", 1000, 50),
        Item("city1 NB2 Item", 1100, 50),
        Item("city1 NB3 Item", 1200, 50),
        Item("city1 NB4 Item", 1300, 50),
        Item("city1 NB5 Item", 1400, 50)
    )
    val city2:Array<Item> = arrayOf(
        Item("city2 NB1 Item", 5000, 50),
        Item("city2 NB2 Item", 5200, 50),
        Item("city2 NB3 Item", 5400, 50),
        Item("city2 NB4 Item", 5600, 50),
        Item("city2 NB5 Item", 5800, 50)
    )
    val city3:Array<Item> = arrayOf(
        Item("city3 NB1 Item", 10000, 50),
        Item("city3 NB2 Item", 11000, 50),
        Item("city3 NB3 Item", 12000, 50),
        Item("city3 NB4 Item", 13000, 50),
        Item("city3 NB5 Item", 14000, 50)
    )
    val city4:Array<Item> = arrayOf(
        Item("city4 NB1 Item", 15000, 50),
        Item("city4 NB2 Item", 17000, 50),
        Item("city4 NB3 Item", 19000, 50),
        Item("city4 NB4 Item", 21000, 50),
        Item("city4 NB5 Item", 23000, 50)
    )

    fun cls(){                                                                                                          //Clear Console
        for(i in 0..75) println("\n")
    }
    fun String.md5(): String{
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
    }

    fun UserSet(user: Array<Int>):User {                                                                             //set userinfo
        user_info.Money = if(user.get(0)!=-1) user.get(0) else user_info.Money                                  //has money
        user_info.Train = if(user.get(1)!=-1) user.get(1) else user_info.Train                                  //has train
        user_info.City = if(user.get(2)!=-1) user.get(2) else user_info.City                                    //open city

        return user_info
    }
    fun Save(user:User){
        var text="${user.Money}\n${user.City}\n${user.Train}"
        File("savefile.md").writeText(text)
        File("savefile.hash").writeText(text.md5())
        var next=0
        while (next==0){
            if(user.Item==null){
                File("saveitem.md").writeText("")
                break
            }
            text="${user.Item!!.Name}\n${user.Item!!.Value}\n${user.Item!!.Count}"
            File("saveitem.md").writeText(text)
            if(user.Item!!.NextItem != null){
                File("saveitenm.md").writeText("\n")
                user.Item=user_info.Item!!.NextItem
            }else break
        }
        text=File("saveitem.md").readText()
        File("saveitem.hash").writeText(text.md5())
        println("Success save")
        println("I hope you enjoyed this game")
        exitProcess(0)
    }
    fun Load():User{
        try {
            var plantext= File("savefile.md").readLines()
            plantext = File("savefile.hash").readLines()
            plantext = File("saveitem.md").readLines()
            plantext = File("saveitem.hash").readLines()
        }
        catch (e: FileNotFoundException){
            println("Save File doesn't exist")
            exitProcess(0)
        }
        catch (e: IndexOutOfBoundsException){
            println("Save File Contents Error")
            exitProcess(0)
        }

        GlobalScope.launch {
            var plantext1 = File("savefile.md").readText()
            var hashtext1 = File("savefile.hash").readText()
            delay(100L)
            var plantext2 = File("saveitem.md").readText()
            var hashtext2 = File("saveitem.hash").readText()
            if(plantext1.md5()!=hashtext1){
                println("Savefile Error")
                exitProcess(0)
            }
            if(plantext2.md5()!=hashtext2){
                println("Itemfile Error")
                exitProcess(0)
            }
        }
        var save = File("savefile.md").readLines()
        user_info.Money=save.get(0).toInt()
        user_info.Train=save.get(1).toInt()
        user_info.City=save.get(2).toInt()
        save = File("saveitem.md").readLines()
        var i=0
        while (true){
            try {
                save.get(0)
            }
            catch (e:IndexOutOfBoundsException){
                user_info.Item=Item()
                break
            }
            user_info.Item?.Name=save.get(i)
            user_info.Item?.Value=save.get(i+1).toInt()
            user_info.Item?.Count=save.get(i+2).toInt()
            if(save.lastIndex<i+3){
                user_info.Item?.NextItem=null
                break
            }else {
                user_info.Item?.NextItem = Item()
                user_info.Item = user_info.Item!!.NextItem
                i+=3
            }
        }
        return user_info
    }
}




package com.example.kotlingame

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileNotFoundException
import java.util.*
import java.security.MessageDigest
import java.math.BigInteger

        data class User(                                                                                                //object user
    var money:Int=0,
    var train:Int=0,
    var city:Int=0,
    var item:Item?=null
)

data class Item(
    var name:String,
    var value:Int,
    var Count:Int,
    var NextItem:Item?=null
)

open class Addit{                                                                                                       //integrated fun & val
    var user_info:User = User()                                                                                         //user info
    val sc: Scanner = Scanner(System.`in`)                                                                              //Scanner temp
    fun cls(){                                                                                                          //Clear Console
        for(i in 0..75) println("\n")
    }
    fun String.md5(): String{
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
    }

    fun UserSet(user: Array<String>):User {                                                                             //set userinfo
        user_info.money = user.get(0).toInt()                                                                           //has money
        user_info.train = user.get(1).toInt()                                                                           //has train
        user_info.city = user.get(2).toInt()                                                                            //open city

        return user_info
    }
    fun Save(user: User){
        var text="${user.money}\n${user.city}\n${user.train}"
        File("savefile.md").writeText(text)
        File("savefile.hash").writeText(text.md5())
        var next=0
        while (next==0){
            text="${user.item!!.name}, ${user.item!!.value}, ${user.item!!.Count}"
            File("saveitem.md").writeText(text)
            if(user.item!!.NextItem != null){
                File("saveitenm.nd").writeText("\n")
                user.item=user.item!!.NextItem
            }else break
        }
        text=File("saveitem.md").readText()
        File("saveitem.hash").writeText(text.md5())
    }
    fun Load(){
        GlobalScope.launch {
            var plantext = File("savefile.md").readText()
            var hashtext = File("savefile.hash").readText()
            delay(1000L)
        }
        try {
            val save= File("savefile.md").readLines()
            user_info=UserSet(arrayOf(save[0], save[1], save[2]))
            println("Game Loading")
            println("${user_info.money}, ${user_info.train}, ${user_info.city}")
        }
        catch (e: FileNotFoundException){
            println("Save File doesn't exist")
        }
        catch (e: IndexOutOfBoundsException){
            println("Save File Contents Error")
        }
        City().Menu(user_info)
    }
    class main_act{                                                                                                     //main_page fun & var

    }
}




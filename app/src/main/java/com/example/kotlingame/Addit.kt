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
    var Name:String,
    var Value:Int,
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
        user_info.Money = user.get(0).toInt()                                                                           //has money
        user_info.Train = user.get(1).toInt()                                                                           //has train
        user_info.City = user.get(2).toInt()                                                                            //open city

        return user_info
    }
    fun Save(user: User){
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
                user.Item=user.Item!!.NextItem
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
            delay(1000L)
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
                user_info.Item=Item("",0,0,null)
                break
            }
            user_info.Item!!.Name=save.get(i)
            user_info.Item!!.Value=save.get(i+1).toInt()
            user_info.Item!!.Count=save.get(i+2).toInt()
            if(save.get(i+3)==null){
                user_info.Item!!.NextItem=null
                break
            }else {
                user_info.Item!!.NextItem = Item("", 0, 0)
                user_info.Item = user_info.Item!!.NextItem
                i+=3
            }
        }

        return user_info
    }
    class main_act{                                                                                                     //main_page fun & var

    }
}




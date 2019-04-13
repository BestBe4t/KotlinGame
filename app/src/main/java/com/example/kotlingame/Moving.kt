package com.example.kotlingame

import java.io.File

class Moving:Addit(){                                                                                                   //moving_page fun & var
    fun menu(user: User) {                                                                                              //moving page activate all train's are move
        println("All Train's are moving")
        println("1. Train's Progress, 2. Save & Exit")
        when(sc.nextLine()){
            "1"->println("Train's Progress")
            "2"->{
                println("Save & Exit")
            }
            else -> println("Your input is Wrong")
        }
    }
}
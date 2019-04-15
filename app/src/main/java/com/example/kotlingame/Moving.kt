package com.example.kotlingame

class Moving:Addit(){                                                                                                   //moving_page fun & var
    fun menu(user: User) {                                                                                              //moving page activate all train's are move
        while (true) {
            println("All Train's are moving")
            println("1. Train's Progress, 2. Save & Exit")
            when (sc.nextLine()) {
                "1" -> println("Train's Progress")
                "2" -> {
                    Save(user)
                    println("I hope you enjoyed this game")
                }
                else -> println("Your input is Wrong")
            }
        }
        cls()
    }
}
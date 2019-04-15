package com.example.kotlingame

class City:Addit(){                                                                                                     //city_page fun & var
    fun Menu(user: User){
        while(true) {
            println("City Name : ${user.City}, Money : ${user.Money}")
            println("1. Buy, 2. Sell, 3. Upgrade, 4. Move Or Change Train, 5. Save & Exit")
            when (sc.nextLine()) {
                "1" -> println("Buy product")
                "2" -> println("Sell product")
                "3" -> println("Upgrade mod")
                "4" -> Moving().menu(user)
                "5" -> {
                    Save(user)
                }
                else -> println("Your input is Wrong")
            }
            cls()
        }
    }

    fun Buy(user: User){

    }

    fun Sell(user: User){

    }

    fun Upgrade(user: User){

    }
}
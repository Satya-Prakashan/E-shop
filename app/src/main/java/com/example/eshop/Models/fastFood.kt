package com.example.eshop.Models

import com.example.eshop.R
import java.io.Serializable


var listfastfood = ArrayList<fastFood>()

data class fastFood(val title: String, val description: String, val image: Int, val price: String): Serializable



fun setItemss(_listitem: ArrayList<fastFood>){
    listfastfood.clear()
    listfastfood = _listitem
}

//It fetches all the lamp models
fun getAllLamps(): ArrayList<fastFood>{
    return listfastfood
}

fun addtoList(){
    val listItem=ArrayList<fastFood>()
    listItem.add(fastFood("Pizza","Yummy!", R.drawable.pizza1,"99"))
    listItem.add(fastFood("Pizza","Yummy!", R.drawable.burger,"69"))
    listItem.add(fastFood("Pizza","Yummy!", R.drawable.pizza1,"99"))
    listItem.add(fastFood("Pizza","Yummy!", R.drawable.pizza1,"99"))
    listItem.add(fastFood("Pizza","Yummy!", R.drawable.pizza1,"99"))
    listItem.add(fastFood("Pizza","Yummy!", R.drawable.pizza1,"99"))
    listItem.add(fastFood("Pizza","Yummy!", R.drawable.pizza1,"99"))
    listItem.add(fastFood("Pizza","Yummy!", R.drawable.pizza1,"99"))
    listItem.add(fastFood("Pizza","Yummy!", R.drawable.pizza1,"99"))

    setItemss(listItem)
}
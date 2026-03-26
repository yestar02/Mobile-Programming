package com.example.console.data.model

import com.example.console.util.nowText

data class Item(
    val id : Int,
    var title:String,
    var done : Boolean = false,
    val createdTime:String = nowText()
)

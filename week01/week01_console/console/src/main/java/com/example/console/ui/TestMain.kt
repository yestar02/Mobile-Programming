package com.example.console.ui

import com.example.console.data.model.Item
import com.example.console.util.enableUtf8Console
import com.example.console.util.nowText
import com.example.console.util.toIntOrNullSafe

fun main(){
    enableUtf8Console()

    val item1 = Item(1,"과제하기")
    val item2 = Item(2, "과제하기2", true)
    val item3 = Item(3, "과제하기3", createdTime = "03-03 12:00")

    println(item1)
    println(item2)
    println(item3)



}


fun printMenu() {
    println()
    println("===== Smart Task & Note Manager =====")
    println("1. 항목 추가")
    println("2. 전체 목록 보기")
    println("3. 키워드 검색")
    println("4. 종료")
}
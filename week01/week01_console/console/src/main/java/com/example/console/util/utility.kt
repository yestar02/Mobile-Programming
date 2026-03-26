package com.example.console.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun nowText(): String =
    LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd HH:mm"))


fun String?.toIntOrNullSafe():Int? = this?.trim()?.toIntOrNull()

fun readNonBlankLine(prompt: String) : String {
    while(true){
        print(prompt)
        val line = readlnOrNull()?.trim()
        if(!line.isNullOrEmpty()) return line
        println("빈 값은 입력할 수 없습니다. 다시 입력해 주세요.")
    }
}

fun readIntOrNull(): Int? {
    print("메뉴 선택 : ")
    return readlnOrNull().toIntOrNullSafe()
}



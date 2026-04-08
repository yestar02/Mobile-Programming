package com.example.dressitem.data.model

import com.example.dressitem.R

data class DressingItem(
    val name : String,
    val id : Int,
    val isSelected : Boolean = false,
    val drawLevel : Int
)

val dressingParts = listOf(
    DressingItem("arms", R.drawable.arms, drawLevel = 1),
    DressingItem("body", R.drawable.body, drawLevel = 0),
    DressingItem("ears", R.drawable.ears, drawLevel = 1),
    DressingItem("eyebrows", R.drawable.eyebrows, drawLevel = 2),
    DressingItem("eyes", R.drawable.eyes, drawLevel = 1),
    DressingItem("glasses", R.drawable.glasses, drawLevel = 3),
    DressingItem("hat", R.drawable.hat, drawLevel = 3),
    DressingItem("mouth", R.drawable.mouth, drawLevel = 1),
    DressingItem("mustache", R.drawable.mustache, drawLevel = 3),
    DressingItem("nose", R.drawable.nose, drawLevel = 1),
    DressingItem("shoes", R.drawable.shoes, drawLevel = 1),
)
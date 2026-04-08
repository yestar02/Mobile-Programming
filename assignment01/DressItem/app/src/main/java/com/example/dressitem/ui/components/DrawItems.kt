package com.example.dressitem.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.dressitem.R
import com.example.dressitem.data.model.DressingItem

@Composable
fun DrawItems(
    itemList : List<DressingItem>,
    modifier : Modifier = Modifier
){

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,

    ){
        Image(
            painter = painterResource(R.drawable.body),
            contentDescription = "Base Body" // 몸통은 일단 그리기
        )

        itemList
            .filter { it.isSelected && it.name != "body" }
            .sortedBy { it.drawLevel }
            .forEach { item ->
                Image(
                    painter = painterResource(id = item.id),
                    contentDescription = item.name
                )
            }

    }
}


package com.example.dressitem.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.dressitem.R
import com.example.dressitem.data.model.DressingItem
import com.example.dressitem.data.model.dressingParts

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
            contentDescription = "Base Body"
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

@Preview
@Composable
private fun DrawItemsPreview() {
    val mockItemList = dressingParts.map { item ->
        if (item.name in listOf("glasses", "hat", "arms")) {
            item.copy(isSelected = true) // 이 3개만 선택된 상태로 변경
        } else {
            item
        }
    }
    DrawItems(itemList = mockItemList)
}
package com.example.dressitem.viewmodel

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.dressitem.data.model.DressingItem
import com.example.dressitem.data.model.dressingParts

class DressItemViewModel : ViewModel(){

    val itemList = dressingParts.toMutableStateList()

    val selectedItem = { item : DressingItem ->
        val index = itemList.indexOf(item)
        if (index != 1){
            itemList[index] = item.copy(isSelected = !item.isSelected)
        }
    }

}
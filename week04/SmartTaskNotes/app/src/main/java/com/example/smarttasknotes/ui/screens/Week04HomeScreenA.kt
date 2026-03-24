package com.example.smarttasknotes.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smarttasknotes.data.mock.MockDataFactory
import com.example.smarttasknotes.data.model.TaskNoteType
import com.example.smarttasknotes.ui.components.TaskNoteItem
import com.example.smarttasknotes.ui.components.TaskNoteTitle
import com.example.smarttasknotes.util.nowText

@Composable
fun Week04HomeScreenA(modifier: Modifier = Modifier) {
    val itemList = remember {
        MockDataFactory.getDataList()
    }

    var title by remember {
        mutableStateOf("")
    }

    fun addTaskItem(){
        if (title.isEmpty()) return
        val task = TaskNoteType.Task(
            id = itemList.size,
            title = title
        )
        itemList.add(task)
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        TaskNoteTitle()
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "입력한 내용을 바로 목록에 추가해보세요 ✨",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        // TODO : 타이틀 입력받고, 추가하는 기능 추가

        OutlinedTextField(
            value = title,
            onValueChange = {
                title = it
            },
            label ={
                Text(text="제목")
            },
            modifier= Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {addTaskItem()},
            modifier = Modifier.fillMaxWidth()
            ) {
            Text(text="등록")
        }

        Spacer(modifier = Modifier.height(20.dp))

        if (itemList.isEmpty()) {
            Text(
                text = "📭 아직 등록된 항목이 없습니다.",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        } else {
            // TODO : Task/Note 출력 로직 구현
            itemList.forEach {
                TaskNoteItem(item=it)
                Spacer(Modifier.height(8.dp))
            }

        }
    }
}

@Preview
@Composable
private fun Week04HomeScreenAPreview() {
    Week04HomeScreenA()
}
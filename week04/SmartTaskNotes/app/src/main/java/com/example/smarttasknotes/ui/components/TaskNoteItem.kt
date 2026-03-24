package com.example.smarttasknotes.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smarttasknotes.data.mock.MockDataFactory
import com.example.smarttasknotes.data.model.TaskNoteType

// TODO : Task/Note 구분하여 출력 로직 구현
@Composable
fun TaskNoteItem(
    item: TaskNoteType,
    modifier: Modifier = Modifier
) {
    when (item){
        is TaskNoteType.Task -> TaskItem(item = item)
        is TaskNoteType.Note -> NoteItem(item = item)
    }
    
}

// TODO : TaskNoteItem 미리보기 구현하기
@Preview
@Composable
private fun TaskNoteItemPreview() {
    val items = MockDataFactory.getDataList()
    Column() {
        items.forEach {
            TaskNoteItem(item = it)
            Spacer(Modifier.height(8.dp))
        }
    }


}

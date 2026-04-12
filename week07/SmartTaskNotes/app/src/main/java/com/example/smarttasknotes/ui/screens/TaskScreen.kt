package com.example.smarttasknotes.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.smarttasknotes.data.model.TaskNoteType
import com.example.smarttasknotes.ui.components.TaskItem

@Composable
fun TaskScreen(
    taskList: List<TaskNoteType.Task>,
    toggleTaskDone: (Int) -> Unit,
    onDeleteTask: (TaskNoteType.Task) -> Unit,
    onNavigateToAdd: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items = taskList) {
            TaskItem(
                item = it,
                toggleTaskDone = toggleTaskDone,
                onDeleteTask = onDeleteTask,
                modifier = Modifier.clickable { onNavigateToAdd(it.id) }
            )
        }
    }
}
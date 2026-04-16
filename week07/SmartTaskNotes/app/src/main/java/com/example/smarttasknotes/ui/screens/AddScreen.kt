package com.example.smarttasknotes.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smarttasknotes.bottomsheet.EmojiBottomSheet
import com.example.smarttasknotes.ui.components.TextInput
import com.example.smarttasknotes.util.HomeTab
import com.example.smarttasknotes.viewmodel.AddUiActions
import com.example.smarttasknotes.viewmodel.AddUiState

@Composable
fun AddScreen(
    state: AddUiState,
    actions: AddUiActions,
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            text = if (state.editingId != -1) "✨ 항목 수정" else "✨ 새 항목 추가",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(16.dp))

        Text(
            text = "입력한 내용을 바로 목록에 추가해보세요 ✨",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(Modifier.height(12.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = state.title,
                onValueChange = actions.onTitleChange,
                label = { Text("제목") },
                modifier = Modifier.weight(1f)
            )

            OutlinedButton(
                onClick = { /*TODO()*/ },
                modifier = Modifier.size(50.dp),
                contentPadding = PaddingValues(0.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(text = "😊", fontSize = 24.sp)
            }
        }

        Spacer(Modifier.height(8.dp))

        if (state.selectedHomeTab == HomeTab.NOTE) {
            TextInput(
                value = state.content,
                label = "📝 내용",
                onValueChange = actions.onContentChange
            )
        } else {
            TextInput(
                value = state.dueDate,
                label = "📅 마감일",
                onValueChange = actions.onDueDateChange
            )
        }

        Spacer(Modifier.height(8.dp))

        Button(
            onClick = {
                actions.saveItem()
                onNavigateBack()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = when {
                    state.editingId == -1 && state.selectedHomeTab == HomeTab.TASK -> "✅ Task 저장"
                    state.editingId == -1 && state.selectedHomeTab == HomeTab.NOTE -> "📝 Note 저장"
                    state.selectedHomeTab == HomeTab.TASK -> "✅ Task 수정"
                    else -> "📝 Note 수정"
                }
            )
        }
    }

}
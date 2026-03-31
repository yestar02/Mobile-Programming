package com.example.smarttasknotes.ui.components

import android.R.attr.label
import android.R.attr.onClick
import android.R.attr.text
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smarttasknotes.util.HomeTab

@Composable
fun SingleChoiceButton(
    selectedHomeTab:HomeTab,
    onChangeSelectedHomeTab:(HomeTab)->Unit,
    modifier: Modifier = Modifier
) {

    val options = listOf(HomeTab.TASK, HomeTab.NOTE)

   SingleChoiceSegmentedButtonRow(
        modifier = Modifier
           .fillMaxWidth()
           .padding(top = 16.dp)
    ) {
       options.forEachIndexed { index, itemType ->
            SegmentedButton(
               shape = SegmentedButtonDefaults.itemShape(
                   index = index,
                   count = options.size
               ),
                selected = selectedHomeTab==itemType,
                onClick = {onChangeSelectedHomeTab(itemType)},
                label = {
                    Text(
                        text = when (itemType) {
                           HomeTab.TASK -> "Task"
                           HomeTab.NOTE -> "Note"
                       }
                    )
                }
            )
       }
    }
}

@Preview
@Composable
private fun SingleChoiceButtonPreview() {

}

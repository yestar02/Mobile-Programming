package com.example.smarttasknotes.drawer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import com.example.smarttasknotes.navigation.NavRoute

@Composable
fun AppDrawerContent(
    currentDestination: NavDestination?,
    onNavigate: (NavRoute) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    ModalDrawerSheet(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = null,
                modifier = Modifier.size(56.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(Modifier.height(8.dp))
            Text(text="📝 Smart Task & Note", style = MaterialTheme.typography.titleLarge)
            Text(
                text = "메뉴를 선택하세요",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        HorizontalDivider()
        Spacer(Modifier.height(8.dp))

        drawerNavItems.forEach { item ->
            NavigationDrawerItem(
                label    = { Text(item.label) },
                icon     = { Icon(item.icon, contentDescription = item.label) },
                selected = currentDestination?.let { item.isSelected(it) } ?: false,
                onClick  = { onNavigate(item.route) },
                modifier = Modifier.padding(horizontal = 12.dp)
            )
        }

        Spacer(Modifier.weight(1f))
        HorizontalDivider()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButton(onClick = onClose) {
                Icon(Icons.Filled.Close, contentDescription = null)
                Spacer(Modifier.width(4.dp))
                Text("닫기")
            }
        }
    }
}
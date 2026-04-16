package com.example.smarttasknotes.bottombar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.StickyNote2
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Task
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.smarttasknotes.navigation.NavRoute

data class BottomNavItem(
    val label: String,
    val icon: ImageVector,
    val route: NavRoute,
)

val bottomNavItems = listOf(
    BottomNavItem(
        label = "홈",
        icon  = Icons.Filled.Home,
        route = NavRoute.Home
    ),
    BottomNavItem(
        label = "태스크",
        icon  = Icons.Filled.Task,
        route = NavRoute.Task
    ),
    BottomNavItem(
        label = "노트",
        icon  = Icons.AutoMirrored.Filled.StickyNote2,
        route = NavRoute.Note
    )
)

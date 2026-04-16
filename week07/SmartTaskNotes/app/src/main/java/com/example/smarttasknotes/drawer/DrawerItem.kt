package com.example.smarttasknotes.drawer

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.StickyNote2
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Task
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import com.example.smarttasknotes.navigation.NavRoute

data class DrawerItem(
    val label: String,
    val icon: ImageVector,
    val route: NavRoute,
    val isSelected: (NavDestination) -> Boolean
)

val drawerNavItems = listOf(
    DrawerItem(
        label      = "홈",
        icon       = Icons.Filled.Home,
        route      = NavRoute.Home,
        isSelected = { it.hasRoute<NavRoute.Home>() }
    ),
    DrawerItem(
        label      = "태스크",
        icon       = Icons.Filled.Task,
        route      = NavRoute.Task,
        isSelected = { it.hasRoute<NavRoute.Task>() }
    ),
    DrawerItem(
        label      = "노트",
        icon       = Icons.AutoMirrored.Filled.StickyNote2,
        route      = NavRoute.Note,
        isSelected = { it.hasRoute<NavRoute.Note>() }
    ),
)
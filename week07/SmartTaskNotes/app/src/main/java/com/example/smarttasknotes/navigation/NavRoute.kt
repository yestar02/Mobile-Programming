package com.example.smarttasknotes.navigation

import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import kotlinx.serialization.Serializable

@Serializable
sealed class NavRoute {
    abstract val title: String
    abstract val showFab: Boolean
    abstract val showBottomBar: Boolean
    abstract val isRoot: Boolean

    fun isSelected(destination: NavDestination?): Boolean =
        destination?.hasRoute(this::class) == true

    @Serializable
    data object Home : NavRoute() {
        override val title = "Home"
        override val showFab = false
        override val showBottomBar = true
        override val isRoot = true
    }

    @Serializable
    data object Task : NavRoute() {
        override val title = "Task List"
        override val showFab = true
        override val showBottomBar = true
        override val isRoot = true
    }

    @Serializable
    data object Note : NavRoute() {
        override val title = "Note List"
        override val showFab = true
        override val showBottomBar = true
        override val isRoot = true
    }

    @Serializable
    data class Add(val id: Int = -1) : NavRoute() {
        override val title = "Add New Item"
        override val showFab = false
        override val showBottomBar = false
        override val isRoot = false
    }
}
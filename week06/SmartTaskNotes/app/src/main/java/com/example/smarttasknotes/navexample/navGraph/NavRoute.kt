package com.example.smarttasknotes.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class NavRoute {
    @Serializable
    object HomeScreen: NavRoute()

    @Serializable
    data class AddScreen(val itemId: Int): NavRoute()
}
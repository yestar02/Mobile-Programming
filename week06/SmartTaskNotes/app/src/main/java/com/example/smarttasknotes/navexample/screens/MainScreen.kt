package com.example.smarttasknotes.navexample.screens

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.smarttasknotes.navexample.navGraph.NavGraph

@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    val navController = rememberNavController()
    //NavGraph(navController = navController)
    NavGraph(navController = navController)

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Log.d(
        "BackStack",
        "$currentRoute"
    )

}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}
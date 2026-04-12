package com.example.smarttasknotes.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.smarttasknotes.navigation.NavRoute
import com.example.smarttasknotes.drawer.AppDrawerContent
import com.example.smarttasknotes.bottombar.BottomNavigationBar
import com.example.smarttasknotes.navigation.TaskNoteAppNavGraph
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val currentRoute: NavRoute = when {
        currentDestination?.hasRoute<NavRoute.Home>() == true -> NavRoute.Home
        currentDestination?.hasRoute<NavRoute.Task>() == true -> NavRoute.Task
        currentDestination?.hasRoute<NavRoute.Note>() == true -> NavRoute.Note
        currentDestination?.hasRoute<NavRoute.Add>() == true -> NavRoute.Add()
        else -> NavRoute.Home
    }

    val onNavigate: (NavRoute) -> Unit = { route ->
        navController.navigate(route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    Scaffold(
        topBar = {
            TopAppBar( // 추가 @OptIn(ExperimentalMaterial3Api::class)
                title = { Text(text = currentRoute.title) },
                navigationIcon = {
                    if (currentRoute.isRoot) {
                        IconButton(onClick = {
                            /* TODO() */
                        }) {
                            Icon(Icons.Filled.Menu, contentDescription = "메뉴")
                        }
                    } else {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "뒤로가기"
                            )
                        }
                    }
                }
            )
        },
        bottomBar = {

        },
        floatingActionButton = {

        }
    ) { paddingValues ->
        TaskNoteAppNavGraph(
            navController = navController,
            modifier = modifier.padding(paddingValues)
        )
    }
}


@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}
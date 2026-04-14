package com.example.smarttasknotes.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.smarttasknotes.ui.screens.Week06AddScreen
import com.example.smarttasknotes.ui.screens.Week06HomeScreenB
import com.example.smarttasknotes.viewmodel.TaskNoteViewModelB


@Composable
fun TaskNoteAppNavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoute.HomeScreen
    ) {
        composable<NavRoute.HomeScreen> {
            val vm: TaskNoteViewModelB = viewModel()
            Week06HomeScreenB(
                homeUiState = vm.homeUiState,
                homeUiActions = vm.homeUiActions,
                onNavigateAddScreen = { id ->
                    navController.navigate(route = NavRoute.AddScreen(itemId = id))
                }
            )
        }

        composable<NavRoute.AddScreen> { backStackEntry ->
            val route: NavRoute.AddScreen = backStackEntry.toRoute()
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry<NavRoute.HomeScreen>()
            }
            val vm: TaskNoteViewModelB = viewModel(parentEntry)

            LaunchedEffect(route.itemId) {
                vm.onChangeEditingId(route.itemId)
            }

            Week06AddScreen(
                state = vm.addUiState,
                actions = vm.addUiActions,
                onNavigateBack = {
                    navController.navigateUp()
                    //navController.popBackStack()
                }
            )
        }
    }
}
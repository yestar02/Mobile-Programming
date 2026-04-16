package com.example.smarttasknotes.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.smarttasknotes.data.model.TaskNoteType
import com.example.smarttasknotes.ui.screens.AddScreen
import com.example.smarttasknotes.ui.screens.HomeScreen
import com.example.smarttasknotes.ui.screens.NoteScreen
import com.example.smarttasknotes.ui.screens.TaskScreen
import com.example.smarttasknotes.util.HomeTab
import com.example.smarttasknotes.viewmodel.TaskNoteViewModel

@Composable
fun TaskNoteAppNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val vm: TaskNoteViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = NavRoute.Home,
        modifier = modifier
    ) {
        composable<NavRoute.Home> {
            HomeScreen()
        }

        composable<NavRoute.Task> {
            LaunchedEffect(Unit) {
                vm.onHomeTabChange(HomeTab.TASK)
            }

            TaskScreen(
                taskList = vm.filteredItems.filterIsInstance<TaskNoteType.Task>(),
                toggleTaskDone = vm.toggleTaskDone,
                onDeleteTask = vm.onDeleteTask,
                onNavigateToAdd = { id ->
                    navController.navigate(NavRoute.Add(id = id))
                }
            )
        }

        composable<NavRoute.Note> {
            LaunchedEffect(Unit) {
                vm.onHomeTabChange(HomeTab.NOTE)
            }

            NoteScreen(
                noteList = vm.filteredItems.filterIsInstance<TaskNoteType.Note>(),
                onNavigateToAdd = { id ->
                    navController.navigate(NavRoute.Add(id = id))
                }
            )
        }

        composable<NavRoute.Add> { backStackEntry ->
            val route: NavRoute.Add = backStackEntry.toRoute()

            LaunchedEffect(route.id) {
                vm.onChangeEditingId(route.id)
            }

            AddScreen(
                state = vm.addUiState,
                actions = vm.addUiActions,
                onNavigateBack = { navController.navigateUp() }
            )
        }
    }
}
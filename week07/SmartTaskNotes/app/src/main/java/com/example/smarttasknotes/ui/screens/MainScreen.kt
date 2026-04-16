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
                saveState = true  // 사용자가 입력해 둔것 저장
            }
            launchSingleTop = true  // 백스택에 중복된 요소가 오지 않게
            restoreState = true //아까 save한 거 복구
        }
    }

    Scaffold(
        topBar = {
            TopAppBar( // 추가 @OptIn(ExperimentalMaterial3Api::class)
                title = { Text(text = currentRoute.title) },
                navigationIcon = {
                    if (currentRoute.isRoot) { // 루트이면 햄버거 메뉴 보아게
                        IconButton(onClick = {
                            /* TODO() */
                        }) {
                            Icon(Icons.Filled.Menu, contentDescription = "메뉴")
                        }
                    } else { // 루트가 아니면 좌측 상단 백 버튼 추가
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
            if(currentRoute.showBottomBar){
                BottomNavigationBar(
                    currentDestination = currentDestination,
                    onNavigate = onNavigate
                )
            }

        },
        floatingActionButton = {
            if(currentRoute.showFab){ // boolean 값에 따라 플로팅 액션 버튼을 보여줌
                FloatingActionButton(
                    onClick = {
                        navController.navigate(route = NavRoute.Add(-1)) // 눌렀을 때 새 항목 추가하는 화면으로 전환
                    }
                ) {
                   Icon(Icons.Default.Add, contentDescription = "Add")
                }
            }
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
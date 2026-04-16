package com.example.smarttasknotes.navigation

import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import kotlinx.serialization.Serializable

@Serializable
sealed class NavRoute {
    abstract val title: String
    abstract val showFab: Boolean // 홈 화면과 수정화면에서 플로팅 버튼 안 보이게
    abstract val showBottomBar: Boolean // 버튼 바를 출력할 건지에 관한 변수, 항목 추가와 수정에서는 안 보이게
    abstract val isRoot: Boolean // 루트아이템이면 햄버거 버튼, 루트 아이템이 아니면 좌측 상단에 뒤로가기 추가

    fun isSelected(destination: NavDestination?): Boolean =
        destination?.hasRoute(this::class) == true // 지금 선택된 게 여기 클래스 객체야? 하고 확인

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
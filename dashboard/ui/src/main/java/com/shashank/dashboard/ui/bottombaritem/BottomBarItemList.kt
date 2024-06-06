package com.shashank.dashboard.ui.bottombaritem

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

val bottomBarItemList = listOf(
    BottomNavItem(
        label = "Home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        route = BottomNavigationRoutes.HomeScreen,
        badgeCount = 0,
        hasNotification = false
    ),
    BottomNavItem(
        label = "Search",
        selectedIcon = Icons.Filled.Search,
        unselectedIcon = Icons.Outlined.Search,
        route = BottomNavigationRoutes.LiveScreen,
        badgeCount = 0,
        hasNotification = false
    ),
    BottomNavItem(
        label = "Profile",
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Outlined.Person,
        route = BottomNavigationRoutes.ProfileScreen,
        badgeCount = 0,
        hasNotification = false
    ),
)


data class BottomNavItem(
    val label: String?,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val route: BottomNavigationRoutes,
    val badgeCount: Int?,
    val hasNotification: Boolean?
)

enum class BottomNavigationRoutes(val route: String) {
    HomeScreen("HomeScree"),
    LiveScreen("LiveScreen"),
    ProfileScreen("ProfileScreen")
}
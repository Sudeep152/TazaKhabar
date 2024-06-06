package com.shashank.dashboard.ui.bottom_sheet_graph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shashank.dashboard.ui.bottombaritem.BottomNavigationRoutes

@Composable
fun DashboardBottomNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavigationRoutes.HomeScreen.route) {
        composable(route= BottomNavigationRoutes.HomeScreen.route) {
            Text(text = "Home")
        }
        composable(route =BottomNavigationRoutes.LiveScreen.route) {
            Text(text = "Live")
        }
        composable( route = BottomNavigationRoutes.ProfileScreen.route) {
            Text(text = "Profile")
        }
    }
}
package com.shashank.core.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shashank.core.routes.Routes
import com.shashank.dashboard.ui.screen.DashboardScreen
import com.shashank.tazakhabar.onboarding.screen.OnBoardingScreen
import com.shashank.ui.screen.AuthenticationScreen
import com.shashank.ui.screen.KeyboardAware

@Composable
fun TazaKhabarNavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController, startDestination = Routes.OnBoardingScreen,
        enterTransition = {
            fadeIn(animationSpec = tween(500)) + slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                tween(500)
            )
        },
        exitTransition = {
            fadeOut(animationSpec = tween(500)) + slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                tween(500)
            )
        },
        popEnterTransition = {
            fadeIn(animationSpec = tween(500)) + slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                tween(500)
            )
        },
        popExitTransition = {
            fadeOut(animationSpec = tween(500)) + slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                tween(500)
            )
        },
    ) {
        composable<Routes.OnBoardingScreen> {
            OnBoardingScreen(navigation = { navController.navigate(Routes.AuthScreen) })
        }
        composable<Routes.AuthScreen> {
            KeyboardAware {
                AuthenticationScreen(
                    navigation = { navController.navigate(Routes.DashboardScreen) },
                    navController
                )
            }
        }
        composable<Routes.DashboardScreen> {
            DashboardScreen()
        }
    }
}
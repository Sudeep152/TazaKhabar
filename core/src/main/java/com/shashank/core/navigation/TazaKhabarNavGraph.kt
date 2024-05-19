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
import com.shashank.tazakhabar.onboarding.screen.OnBoardingScreen
import com.shashank.ui.screen.AuthenticationScreen

@Composable
fun TazaKhabarNavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController, startDestination = Routes.OnBoardingScreen,
        enterTransition = {
            fadeIn(animationSpec = tween(700)) + slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                tween(700)
            )
        },
        exitTransition = {
            fadeOut(animationSpec = tween(700)) + slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                tween(700)
            )
        },
        popEnterTransition = {
            fadeIn(animationSpec = tween(700)) + slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                tween(700)
            )
        },
        popExitTransition = {
            fadeOut(animationSpec = tween(700)) + slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                tween(700)
            )
        },
    ) {
        composable<Routes.OnBoardingScreen> {
            OnBoardingScreen(navigation = { navController.navigate(Routes.AuthScreen) })
        }
        composable<Routes.AuthScreen> {
            AuthenticationScreen(navigation = { navController.navigate(Routes.HomeScreen) },navController)
        }
        composable<Routes.HomeScreen> {
            Text(text = "Home")
        }
    }
}
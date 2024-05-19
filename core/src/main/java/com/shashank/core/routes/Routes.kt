package com.shashank.core.routes

import kotlinx.serialization.Serializable

class Routes {
    @Serializable
    data object AppStartNavigation
    @Serializable
    object OnBoardingScreen
    @Serializable
    object AuthScreen
    @Serializable
    object HomeScreen
}
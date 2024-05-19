package com.shashank.common.navigation

import kotlinx.serialization.Serializable


class Screens {
    @Serializable
    object AuthScreen

    @Serializable
    data class HomeScreen(val name: String = "")
}
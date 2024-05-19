package com.shashank.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.shashank.common.navigation.Screens

@Composable
fun HelloScreenFromAuth(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(color = Color.Red)
        )
        Text(text = "Hello From there", modifier = Modifier.clickable {
            navController.navigate(Screens.HomeScreen(name = "Shashank Kumar"))
        })
    }

}

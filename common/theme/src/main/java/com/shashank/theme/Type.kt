package com.shashank.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = playFairFontFamily,
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold
    ),
    displayMedium = TextStyle(
        fontFamily = playFairFontFamily,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    ),

    headlineLarge = TextStyle(
        fontFamily = playFairFontFamily,
        fontSize = 27.sp,
        lineHeight = 22.sp,
        fontWeight = FontWeight.Bold,
        color = PrimaryColor
    ),

    headlineMedium = TextStyle(
        fontFamily = playFairFontFamily,
        fontSize = 17.sp,
        lineHeight = 18.sp,
        fontWeight = FontWeight.Bold
    ),
    titleLarge = TextStyle(
        fontSize = 30.sp,
        fontFamily = nunitoFontFamily,
        fontWeight = FontWeight.Bold
    ),

    titleMedium = TextStyle(
        fontSize = 18.sp,
        fontFamily = playFairFontFamily,
        fontWeight = FontWeight.Bold
    ),
    titleSmall = TextStyle(
        fontFamily = playFairFontFamily,
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold
    ),
    bodyLarge = TextStyle(
        fontFamily = playFairFontFamily,
    ),
    bodyMedium = TextStyle(
        fontFamily = playFairFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    bodySmall = TextStyle(
        fontFamily = nunitoFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 15.sp,
    ),

    labelLarge = TextStyle(
        fontFamily = nunitoFontFamily,
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold
    ),

    labelMedium = TextStyle(
        fontFamily = nunitoFontFamily,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold

    ),
    labelSmall = TextStyle(
        fontFamily = playFairFontFamily,
        fontSize = 10.sp,
        fontWeight = FontWeight.SemiBold
    )
)
package com.shashank.tazakhabar.onboarding.data

import androidx.annotation.DrawableRes
import com.shashank.tazakhabar.onboarding.R

data class Page(
    val title: String = "",
    val description: String = "",
    @DrawableRes val image: Int = 0
)

val pagesList = listOf<Page>(
    Page(
        "Choose your Category",
        "The first mate and his Skipper too will do their very comfortable in their tropic island nest to till the end.",
        R.drawable.onboarding1
    ),

    Page(
        "Subscribe Update",
        "The first mate and his Skipper too will do their very comfortable in their tropic island nest to till the end.",
        R.drawable.onboarding2
    ),
    Page(
        "Daily Notifications Update",
        "The first mate and his Skipper too will do their very comfortable in their tropic island nest to till the end.",
        R.drawable.onboarding3
    ),
)

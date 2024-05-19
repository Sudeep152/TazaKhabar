package com.shashank.tazakhabar.onboarding.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.shashank.composable.component.CustomButton
import com.shashank.tazakhabar.onboarding.data.Page
import com.shashank.tazakhabar.onboarding.data.pagesList
import com.shashank.tazakhabar.onboarding.utils.Constants.FIFTEEN_DP
import com.shashank.tazakhabar.onboarding.utils.Constants.FIVE_HUNDRED_DP
import com.shashank.tazakhabar.onboarding.utils.Constants.MIN_PADDING
import kotlin.math.absoluteValue

@Composable
fun OnBoardingScreen(navigation: () -> Unit) {
    val pagerState = rememberPagerState(initialPage = 0) {
        pagesList.size
    }
    val currentItem by remember {
        derivedStateOf {
            pagerState.settledPage
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        HorizontalPager(
            contentPadding = PaddingValues(horizontal = 64.dp),
            state = pagerState,
            modifier = Modifier.height(FIVE_HUNDRED_DP)
        ) {
            SingleTemplateCard(page = it, pagerState = pagerState, item = pagesList[it])
        }
        Text(
            text = pagesList[currentItem].title,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(MIN_PADDING)
        )
        Text(
            text = pagesList[currentItem].description,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(horizontal = FIFTEEN_DP),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(FIFTEEN_DP))
        if (currentItem == pagesList.lastIndex)
            CustomButton(onClick = { navigation() })
    }
}

@Composable
fun SingleTemplateCard(
    page: Int,
    pagerState: PagerState,
    item: Page,
) {
    val pageOffset =
        ((pagerState.currentPage - page) + (pagerState.currentPageOffsetFraction)).absoluteValue
    Card(
        modifier = Modifier
            .graphicsLayer {
                lerp(
                    start = 0.82f,
                    stop = 1f,
                    fraction = 1f - pageOffset.coerceIn(0f, 1f)
                ).also { scale ->
                    scaleX = scale
                    scaleY = scale
                }
            },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = FIFTEEN_DP)
    ) {
        Box(
            Modifier
                .blur(if (pagerState.settledPage == page) 0.dp else 60.dp)
        )
        {
            AsyncImage(
                model = item.image,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
    }
}
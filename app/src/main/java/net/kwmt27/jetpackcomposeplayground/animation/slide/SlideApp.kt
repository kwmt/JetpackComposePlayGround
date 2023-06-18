package net.kwmt27.jetpackcomposeplayground.animation.slide

import android.annotation.SuppressLint
import android.app.Activity
import android.view.WindowManager
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SlideApp() {
    val activity = LocalContext.current as Activity

    LaunchedEffect(key1 = Unit) {
        activity.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }
    var currentIndex by remember {
        mutableStateOf(0)
    }
    var currentMillSec by remember {
        mutableStateOf(5000)
    }
    val pageCount = slides.size
    val pagerState = rememberPagerState { pageCount }

    if (currentIndex < slides.size) {
//        LaunchedEffect(key1 = currentIndex) {
//            delay(5000)
//            currentIndex++
//            currentMillSec = 5000
//        }
//        LaunchedEffect(key1 = currentMillSec) {
//            delay(1000)
//            currentMillSec -= 1000
//        }
    }

    Scaffold {
        if (currentIndex < slides.size) {
            Box {
                HorizontalPager(
                    state = pagerState,
                ) { pageIndex ->
                    SlidePage(
                        slides[pageIndex],
                        currentMillSec,
                    )
                }

                PageIndicator(pageCount, pagerState)
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun BoxScope.PageIndicator(pageCount: Int, pagerState: PagerState) {
    Row(
        Modifier
            .height(50.dp)
            .fillMaxWidth()
            .align(Alignment.BottomCenter),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pageCount) { iteration ->
            val color = if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(20.dp)
            )
        }
    }
}

@Composable
private fun SlidePage(slide: Slide, currentMillSec: Int) {
    Box {
        SlideContent(slide)
        TimerView(currentMillSec)
    }
}

@Composable
private fun TimerView(currentMillSec: Int) {
    Text("$currentMillSec")
}

@Preview(heightDp = 360, widthDp = 800, showBackground = true)
@Composable
private fun PreviewSlideApp() {
    SlidePage(slides[0], 5000)
}


package net.kwmt27.jetpackcomposeplayground.slide

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SlideApp() {
    val activity = LocalContext.current as Activity
//    LaunchedEffect(key1 = Unit) {
//        activity.window.run {
//            WindowCompat.setDecorFitsSystemWindows(this, false)
//            setFlags(
//                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
//                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
//            )
//        }
//    }
    SlideScreen()
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
@OptIn(ExperimentalFoundationApi::class)
private fun SlideScreen() {
    var currentIndex by remember {
        mutableStateOf(0)
    }
    var currentMillSec by remember {
        mutableStateOf(5000)
    }
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
    val requester = remember { FocusRequester() }
    val scope = rememberCoroutineScope()
    Scaffold(
        modifier = Modifier
            .onKeyEvent {
                when (it.key) {
                    Key.DirectionRight,
                    Key.DirectionDown,
                    Key.SoftRight,
                    Key.Enter,
                    -> {
                        if (it.type == KeyEventType.KeyUp) {
                            if (canShowNext(currentIndex)) {
                                currentIndex++
                            }
                        }
                        true
                    }

                    Key.DirectionLeft,
                    Key.DirectionUp,
                    Key.SoftLeft,
                    -> {
                        if (it.type == KeyEventType.KeyUp) {
                            if (canShowPrev(currentIndex)) {
                                currentIndex--
                            }
                        }
                        true
                    }

                    else -> {
                        false
                    }
                }
            }
            .focusRequester(requester)
            .focusable()
    ) {
        if (currentIndex < slides.size) {
            Box() {
                HorizontalPager(
                    state = rememberPagerState { slides.size },
                ) {
                    SlidePage(
                        slides[currentIndex],
                        currentMillSec,
                    )
                }

                PageIndicator(slides.size, currentIndex)
            }
        }
    }
}

private fun canShowNext(currentIndex: Int): Boolean {
    return currentIndex < slides.size - 1
}

private fun canShowPrev(currentIndex: Int): Boolean {
    return currentIndex > 0
}

@Composable
private fun BoxScope.PageIndicator(pageCount: Int, currentPageIndex: Int) {
    Row(
        Modifier
            .height(50.dp)
            .fillMaxWidth()
            .align(Alignment.BottomCenter),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pageCount) { iteration ->
            val color = if (currentPageIndex == iteration) Color.DarkGray else Color.LightGray
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(10.dp)
            )
        }
    }
}

@Composable
private fun SlidePage(slide: Slide, currentMillSec: Int) {
    Box(
        modifier = Modifier.padding(32.dp)
    ) {
        slide.content()
//        TimerView(currentMillSec)
    }
}

@Composable
private fun TimerView(currentMillSec: Int) {
    Text("$currentMillSec")
}

@SlidePreview
@Composable
private fun PreviewSlideApp() {
    SlideScreen()
}

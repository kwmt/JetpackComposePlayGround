package net.kwmt27.jetpackcomposeplayground.animation.slide

import android.annotation.SuppressLint
import android.app.Activity
import android.view.WindowManager
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

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
    if (currentIndex < slides.size) {
        LaunchedEffect(key1 = currentIndex) {
            delay(5000)
            currentIndex++
            currentMillSec = 5000
        }
        LaunchedEffect(key1 = currentMillSec) {
            delay(1000)
            currentMillSec -= 1000
        }
    }

    Scaffold {
        HorizontalPager(pageCount = slides.size) {
            if (currentIndex < slides.size) {
                Box {
                    SlideContent(slides[currentIndex])
                    TimerView(currentMillSec)
                }
            }
        }
    }
}

@Composable
fun TimerView(currentMillSec: Int) {
    Text("$currentMillSec")
}

@Composable
fun SlideContent(slide: Slide) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = slide.title)
        Text(text = slide.content)
    }
}

@Preview(heightDp = 360, widthDp = 800, showBackground = true)
@Composable
fun PreviewSlideApp() {
    SlideApp()
}

data class Slide(val title: String, val content: String)

val slides = listOf(
    Slide("イントロダクション", "自己紹介"),
    Slide("具体的なアニメーションの実装例", "テキストのアニメーションの説明"),
    Slide("実装の詳細とポイントの解説", "他のアニメーションAPIの比較とパフォーマンスについて"),
    Slide("成果と学び", "アニメーションの成果と今後の展望"),
    Slide("まとめと質疑応答", "プレゼンのまとめと質問への対応")
)

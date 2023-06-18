package net.kwmt27.jetpackcomposeplayground.animation.slide

import androidx.compose.runtime.Composable
import net.kwmt27.jetpackcomposeplayground.animation.slide.contents.Intro
import net.kwmt27.jetpackcomposeplayground.animation.slide.contents.SlideTitle

internal data class Slide(
    val title: String? = null,
    val content: @Composable () -> Unit,
)

internal val slides = listOf(
    Slide { SlideTitle() },
    Slide("自己紹介") { Intro() },
    Slide("具体的なアニメーションの実装例") { Intro() },
)

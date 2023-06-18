package net.kwmt27.jetpackcomposeplayground.animation.slide

import androidx.compose.runtime.Composable
import net.kwmt27.jetpackcomposeplayground.animation.slide.contents.Intro

internal data class Slide(
    val title: String,
    val content: @Composable () -> Unit,
)

internal val slides = listOf(
    Slide("自己紹介") { Intro() },
    Slide("具体的なアニメーションの実装例") { Intro() },
)

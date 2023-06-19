package net.kwmt27.jetpackcomposeplayground.animation.slide

import androidx.compose.runtime.Composable
import net.kwmt27.jetpackcomposeplayground.animation.slide.contents.AnimationExample
import net.kwmt27.jetpackcomposeplayground.animation.slide.contents.Intro
import net.kwmt27.jetpackcomposeplayground.animation.slide.contents.Intro2
import net.kwmt27.jetpackcomposeplayground.animation.slide.contents.Intro3
import net.kwmt27.jetpackcomposeplayground.animation.slide.contents.SlideTitle

internal data class Slide(
    val title: String? = null,
    val content: @Composable () -> Unit,
)

internal val slides = listOf(
    Slide { SlideTitle() },
    Slide("自己紹介") { Intro() },
    Slide("どんなアニメーションか？") { Intro2() },
    Slide("どんなアニメーションか？（アニメーション部分のみ・簡略化）") { Intro3() },
    Slide("例1: テキストが下から上に回転するようなアニメーション") { AnimationExample() },
)

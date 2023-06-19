package net.kwmt27.jetpackcomposeplayground.animation.slide.contents

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import net.kwmt27.jetpackcomposeplayground.animation.slide.SlidePreview
import net.kwmt27.jetpackcomposeplayground.animation.slide.SlideTypography

@Composable
fun Intro() {
    Text(
        text = """
        - 河本泰孝
        - AppBrew所属
        - Androidエンジニア
        - LIPSというアプリを作っている
        - Jetpack Composeを使ってアニメーションを実装したので紹介したい
        """.trimIndent(),
        style = SlideTypography.body1,
    )
}

@SlidePreview
@Composable
private fun PreviewIntro() {
    Intro()
}

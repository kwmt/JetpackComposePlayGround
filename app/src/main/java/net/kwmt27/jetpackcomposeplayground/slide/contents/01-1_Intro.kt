package net.kwmt27.jetpackcomposeplayground.slide.contents

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import net.kwmt27.jetpackcomposeplayground.slide.SlidePreview
import net.kwmt27.jetpackcomposeplayground.slide.SlideTypography

@Composable
fun Intro() {
    Text(
        text = """
        - 河本泰孝
        - AppBrew所属
        - Androidエンジニア
        - LIPSというコスメクチコミアプリを作っている
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

package net.kwmt27.jetpackcomposeplayground.animation.slide.contents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.kwmt27.jetpackcomposeplayground.animation.slide.SlideTypography

@Composable
fun Intro() {
    Box(modifier = Modifier.padding(16.dp)) {
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
}

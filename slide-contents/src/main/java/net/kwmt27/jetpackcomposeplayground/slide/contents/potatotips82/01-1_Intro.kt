package net.kwmt27.jetpackcomposeplayground.slide.contents.potatotips82

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.github.kwmt.slide.components.SlideBase
import com.github.kwmt.slide.ui.theme.SlidePreview
import com.github.kwmt.slide.ui.theme.SlideTypography

@Composable
internal fun Intro() {
    SlideBase("自己紹介") {
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
}

@SlidePreview
@Composable
private fun PreviewIntro() {
    Intro()
}

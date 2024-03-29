package net.kwmt27.jetpackcomposeplayground.slide.contents.shibuyaapk43

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.github.kwmt.slide.components.SlideBase
import com.github.kwmt.slide.components.SlideImage
import com.github.kwmt.slide.ui.theme.SlidePreview
import com.github.kwmt.slide.ui.theme.SlideTypography
import net.kwmt27.jetpackcomposeplayground.slide.contents.R

@Composable
internal fun SelfIntro1() {
    SlideBase("自己紹介") {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = """
         - 河本泰孝
         - 株式会社AppBrew所属
         - Androidエンジニア
         - LIPSというコスメクチコミアプリ開発
                """.trimIndent(),
                style = SlideTypography.body1,
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                SlideImage(data = R.drawable.shibuyaapk43_potatotips)
                SlideImage(data = R.drawable.shibuyaapk43_slidesample)
            }
        }
    }
}

@SlidePreview
@Composable
private fun PreviewSelfIntro1() {
    SelfIntro1()
}

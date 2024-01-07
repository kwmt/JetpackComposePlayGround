package net.kwmt27.jetpackcomposeplayground.slide.contents.shibuyaapk43

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import com.github.kwmt.slide.components.Code
import com.github.kwmt.slide.components.SlideBase
import com.github.kwmt.slide.ui.theme.SlidePreview

@Composable
internal fun SlideAppTips1() {
    SlideBase(
        title = "スライドアプリTips",
        subTitle = "スライド全体の作りはHorizontalPagerを使用"
    ) {
        Row {
            Code(path = "shibuyaapk43_05_3_SlideAppTips1.html")
        }
    }
}

@SlidePreview
@Composable
private fun PreviewSlideAppTips() {
    SlideAppTips1()
}

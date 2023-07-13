package net.kwmt27.jetpackcomposeplayground.slide.contents.shibuyaapk43

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.kwmt27.jetpackcomposeplayground.R
import net.kwmt27.jetpackcomposeplayground.slide.SlidePreview
import net.kwmt27.jetpackcomposeplayground.slide.components.Code
import net.kwmt27.jetpackcomposeplayground.slide.components.SlideBase
import net.kwmt27.jetpackcomposeplayground.slide.components.SlideImage

@Composable
internal fun SlideAppTips2() {
    SlideBase(
        title = "スライドアプリTips",
        subTitle = "発表時はLarge Desktopのエミュレータを使う"
    ) {
        Row {
            SlideImage(data = R.drawable.shibuyaapk43_emulator)
            Spacer(modifier = Modifier.size(16.dp))
        }
    }
}

@SlidePreview
@Composable
private fun PreviewSlideAppTips() {
    SlideAppTips2()
}

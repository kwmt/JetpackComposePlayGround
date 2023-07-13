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
internal fun SlideAppTips1() {
    SlideBase(
        title = "スライドアプリTips",
        subTitle = "コードハイライト"
    ) {
        Row {
            SlideImage(data = R.drawable.shibuyaapk43_codehiglight)
            Spacer(modifier = Modifier.size(16.dp))
            Code(path = "shibuyaapk43_05_3_SlideAppTips1.html")
        }
    }
}

@SlidePreview
@Composable
private fun PreviewSlideAppTips() {
    SlideAppTips1()
}

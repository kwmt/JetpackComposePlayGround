package net.kwmt27.jetpackcomposeplayground.slide.contents.shibuyaapk43

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.kwmt.slide.components.Code
import com.github.kwmt.slide.components.SlideBase
import com.github.kwmt.slide.components.SlideImage
import com.github.kwmt.slide.ui.theme.SlidePreview
import net.kwmt27.jetpackcomposeplayground.R

@Composable
internal fun SlideAppTips2() {
    SlideBase(
        title = "スライドアプリTips",
        subTitle = "コードのシンタックスハイライト"
    ) {
        Row {
            SlideImage(data = R.drawable.shibuyaapk43_codehiglight)
            Spacer(modifier = Modifier.size(16.dp))
            Code(path = "shibuyaapk43_05_3_SlideAppTips2.html")
        }
    }
}

@SlidePreview
@Composable
private fun PreviewSlideAppTips() {
    SlideAppTips2()
}

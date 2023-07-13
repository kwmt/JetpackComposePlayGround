package net.kwmt27.jetpackcomposeplayground.slide.contents.shibuyaapk43

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.kwmt27.jetpackcomposeplayground.R
import net.kwmt27.jetpackcomposeplayground.slide.SlidePreview
import net.kwmt27.jetpackcomposeplayground.slide.SlideTypography
import net.kwmt27.jetpackcomposeplayground.slide.components.SlideBase
import net.kwmt27.jetpackcomposeplayground.slide.components.SlideImage

@Composable
internal fun SlideAppTips3() {
    SlideBase(
        title = "スライドアプリTips",
        subTitle = "ツールバーとズームコントロールを消すと少し広く使える"
    ) {
        Column {
            Row {
                SlideImage(data = R.drawable.shibuyaapk43_toolbar)
                Spacer(modifier = Modifier.size(16.dp))
                SlideImage(data = R.drawable.shibuyaapk43_zoomcontrol)
            }

            Text(
                text = "エミュレータのメニューのShow Toolbarのチェックを外せば消えます。",
                style = SlideTypography.body1
            )
            SlideImage(data = R.drawable.shibuyaapk43_emulator_menu)
        }
    }
}

@SlidePreview
@Composable
private fun PreviewSlideAppTips() {
    SlideAppTips3()
}

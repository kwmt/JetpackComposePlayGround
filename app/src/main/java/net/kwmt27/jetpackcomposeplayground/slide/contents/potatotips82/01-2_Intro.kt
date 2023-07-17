package net.kwmt27.jetpackcomposeplayground.slide.contents.potatotips82

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.kwmt27.jetpackcomposeplayground.slide.SlidePreview
import net.kwmt27.jetpackcomposeplayground.slide.SlideTypography
import net.kwmt27.jetpackcomposeplayground.slide.components.ASSET_BASE_PATH
import net.kwmt27.jetpackcomposeplayground.slide.components.SlideBase
import net.kwmt27.jetpackcomposeplayground.slide.components.SlideImage

@Composable
fun Intro2() {
    SlideBase("どんなアニメーションか？") {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            SlideImage(data = "${ASSET_BASE_PATH}lips-ba.gif")
            Spacer(modifier = Modifier.size(16.dp))
            Column {
                Text("1.テキストが下から上に回転するようなアニメーション", style = SlideTypography.body1)
                Spacer(modifier = Modifier.size(16.dp))
                Text("2.横幅いっぱいのレイアウトが左から右にかけて消えていくアニメーション", style = SlideTypography.body1)
                Spacer(modifier = Modifier.size(16.dp))
                Text("3.右のアイコンが色付きアイコンを色なしアイコンに変更する", style = SlideTypography.body1)
            }
        }
    }
}

@SlidePreview
@Composable
private fun PreviewIntro() {
    Intro2()
}

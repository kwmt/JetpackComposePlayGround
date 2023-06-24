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
import net.kwmt27.jetpackcomposeplayground.animation.AutoRollingTextSample5
import net.kwmt27.jetpackcomposeplayground.slide.SlidePreview
import net.kwmt27.jetpackcomposeplayground.slide.SlideTypography

@Composable
fun Intro3() {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AutoRollingTextSample5()
        Spacer(modifier = Modifier.size(16.dp))
        Column {
            Text("1.テキストが下から上に回転するようなアニメーション", style = SlideTypography.body1)
            Spacer(modifier = Modifier.size(16.dp))
            Text("2.緑のボックスが左から右にかけて消えていくアニメーション", style = SlideTypography.body1)
            Spacer(modifier = Modifier.size(16.dp))
            Text("3.右側の青色が赤色に切り替わるアニメーション", style = SlideTypography.body1)
        }
    }
}

@SlidePreview
@Composable
private fun PreviewIntro3() {
    Intro3()
}

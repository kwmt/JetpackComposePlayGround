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
import net.kwmt27.jetpackcomposeplayground.slide.components.Code
import net.kwmt27.jetpackcomposeplayground.slide.components.SlideBase

@Composable
fun AnimationExample3_2() {
    SlideBase("例3: 右の円が青から赤にクロスフェードするアニメーション") {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AutoRollingTextSample5()
            Spacer(modifier = Modifier.size(16.dp))
            Column {
                Text("Crossfade関数で囲うだけです。", style = SlideTypography.body1)
                Spacer(modifier = Modifier.size(16.dp))
                Code(path = "02-3-2_AnimateExample.html")
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    "青色がフェードアウトしながら赤がフェードインしてくるようなアニメーションが完成",
                    style = SlideTypography.body1
                )
            }
        }
    }
}

@SlidePreview
@Composable
private fun PreviewAnimationExample() {
    AnimationExample3_2()
}

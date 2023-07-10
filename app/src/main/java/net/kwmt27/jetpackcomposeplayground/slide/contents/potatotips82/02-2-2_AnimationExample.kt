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
import net.kwmt27.jetpackcomposeplayground.animation.AutoRollingTextSample3
import net.kwmt27.jetpackcomposeplayground.slide.SlidePreview
import net.kwmt27.jetpackcomposeplayground.slide.SlideTypography
import net.kwmt27.jetpackcomposeplayground.slide.components.Code
import net.kwmt27.jetpackcomposeplayground.slide.components.SlideBase

@Composable
fun AnimationExample2_2() {
    SlideBase("例2: 緑のボックスが左から右にかけて消えていくアニメーション") {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AutoRollingTextSample3()
            Spacer(modifier = Modifier.size(16.dp))
            Column {
                Text("AnimatedVisibility関数を使います。", style = SlideTypography.body1)
                Spacer(modifier = Modifier.size(16.dp))
                Code(path = "02-2-2_AnimateExample.html")
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    "if文をAnimatedVisibilityに置き換えるだけです。",
                    style = SlideTypography.body1
                )
                Text(
                    "フェードアウトするのはいいが、高さが小さくなっていくのはやめたい。幅だけ小さくしたい。’",
                    style = SlideTypography.body1
                )
            }
        }
    }
}

@SlidePreview
@Composable
private fun PreviewAnimationExample() {
    AnimationExample2_2()
}

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
import com.github.kwmt.slide.components.Code
import com.github.kwmt.slide.components.SlideBase
import com.github.kwmt.slide.ui.theme.SlidePreview
import com.github.kwmt.slide.ui.theme.SlideTypography
import net.kwmt27.jetpackcomposeplayground.feature.samples.animation.AutoRollingTextSample4

@Composable
internal fun AnimationExample3_1() {
    SlideBase("例3: 右の円が青から赤にクロスフェードするアニメーション") {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AutoRollingTextSample4()
            Spacer(modifier = Modifier.size(16.dp))
            Column {
                Text("isVisibleフラグで色を切り替えてるだけでアニメーションなし", style = SlideTypography.body1)
                Spacer(modifier = Modifier.size(16.dp))
                Code(path = "02-3-1_AnimateExample.html")
            }
        }
    }
}

@SlidePreview
@Composable
private fun PreviewAnimationExample() {
    AnimationExample3_1()
}

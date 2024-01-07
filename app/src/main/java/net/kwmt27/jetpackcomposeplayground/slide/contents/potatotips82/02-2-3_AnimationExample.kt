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
fun AnimationExample2_3() {
    SlideBase("例2: 緑のボックスが左から右にかけて消えていくアニメーション") {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AutoRollingTextSample4()
            Spacer(modifier = Modifier.size(16.dp))
            Column {
                Text("exitトランジションを設定します。", style = SlideTypography.body1)
                Spacer(modifier = Modifier.size(16.dp))
                Code(path = "02-2-3_AnimateExample.html")
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    "緑のボックスが左から右にかけて消えていくアニメーション完成",
                    style = SlideTypography.body1
                )
            }
        }
    }
}

@SlidePreview
@Composable
private fun PreviewAnimationExample() {
    AnimationExample2_3()
}

package net.kwmt27.jetpackcomposeplayground.animation.slide.contents

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
import net.kwmt27.jetpackcomposeplayground.animation.slide.SlidePreview
import net.kwmt27.jetpackcomposeplayground.animation.slide.SlideTypography
import net.kwmt27.jetpackcomposeplayground.animation.slide.components.ASSET_BASE_PATH
import net.kwmt27.jetpackcomposeplayground.animation.slide.components.SlideImage

@Composable
fun Summary() {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column {
            Text("Composeでアニメーションを実装するために、Wrapするだけなどの簡単な関数が用意されている", style = SlideTypography.body1)
            Spacer(modifier = Modifier.size(16.dp))
            Text("アニメーションの関数の決定は公式ドキュメントのフローチャートがわかりやすい", style = SlideTypography.body1)
            Spacer(modifier = Modifier.size(16.dp))
            Text("楽しい", style = SlideTypography.body1)
        }
    }
}

@SlidePreview
@Composable
private fun PreviewIntro() {
    Summary()
}

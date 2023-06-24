package net.kwmt27.jetpackcomposeplayground.slide.contents.potatotips82

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import net.kwmt27.jetpackcomposeplayground.animation.AutoRollingTextSample2
import net.kwmt27.jetpackcomposeplayground.slide.SlidePreview
import net.kwmt27.jetpackcomposeplayground.slide.SlideTypography
import net.kwmt27.jetpackcomposeplayground.slide.components.Code

@Composable
fun AnimationExample1_3() {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val context = LocalContext.current
        AutoRollingTextSample2()
        Spacer(modifier = Modifier.size(16.dp))
        Column {
            Text("トランジションをデフォルトから変更します。", style = SlideTypography.body1)
            Spacer(modifier = Modifier.size(16.dp))
            Code(path = "02-1-3_AnimateExample.html")
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = "※androidx.compose.animation:animation-*:1.5.0-alpha03でwithがtogetherWithにリネームの変更が入っています。",
                style = SlideTypography.caption,
                modifier = Modifier.clickable {
                    context.startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://developer.android.com/jetpack/androidx/releases/compose-animation?hl=en#1.5.0-alpha03")
                        )
                    )
                }
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text("テキストが下から上に回転するようなアニメーションの完成", style = SlideTypography.body1)

            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = "実は公式ドキュメント(https://developer.android.com/jetpack/compose/animation#animatedcontent)にそのまま載っているので参考にしてください。",
                style = SlideTypography.body1,
                modifier = Modifier.clickable {
                    context.startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://developer.android.com/jetpack/androidx/releases/compose-animation?hl=en#1.5.0-alpha03")
                        )
                    )
                }
            )
        }
    }
}

@SlidePreview
@Composable
private fun PreviewAnimationExample() {
    AnimationExample1_3()
}

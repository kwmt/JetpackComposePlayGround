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
import com.github.kwmt.slide.components.SlideBase
import com.github.kwmt.slide.components.SlideImage
import com.github.kwmt.slide.ui.theme.SlidePreview
import com.github.kwmt.slide.ui.theme.SlideTypography
import net.kwmt27.jetpackcomposeplayground.slide.contents.R

@Composable
internal fun DetailsAndPoints3_1() {
    SlideBase("他のアニメーションAPIは？") {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            val context = LocalContext.current
            Column {
                Text(
                    "今回はアニメーションの関数を３つだけ紹介しましたが、他にもいろいろあります。",
                    style = SlideTypography.body1
                )
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    "どれを使えばいいかは公式ドキュメントに決定する際のフローチャートがあるので参考にするとよいと思います。",
                    style = SlideTypography.body1
                )
                Text(
                    "https://developer.android.com/jetpack/compose/animation",
                    style = SlideTypography.body1,
                    modifier = Modifier.clickable {
                        context.startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://developer.android.com/jetpack/compose/animation")
                            )
                        )
                    }
                )
                SlideImage(data = R.drawable.animation_flowchart)
            }
        }
    }
}

@SlidePreview
@Composable
private fun PreviewDetailsAndPoints() {
    DetailsAndPoints3_1()
}

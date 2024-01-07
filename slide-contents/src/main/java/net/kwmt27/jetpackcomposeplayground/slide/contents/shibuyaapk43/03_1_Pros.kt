package net.kwmt27.jetpackcomposeplayground.slide.contents.shibuyaapk43

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.kwmt.slide.components.Code
import com.github.kwmt.slide.components.SlideBase
import com.github.kwmt.slide.ui.theme.SlidePreview
import com.github.kwmt.slide.ui.theme.SlideTypography
import net.kwmt27.jetpackcomposeplayground.feature.samples.animation.AutoRollingTextSample

internal const val PROS1_SUB_TITLE = "Android アプリのコードをそのまま実行できる"
@Composable
internal fun Pros1() {
    SlideBase(
        title = "メリット",
        subTitle = PROS1_SUB_TITLE
    ) {
        Row {
            AutoRollingTextSample()
            Column {
                Code(path = "shibuyaapk43_03_1_Pros1.html")
                Spacer(modifier = Modifier.size(16.dp))
                Text(text = "Keynoteでやろうとすると、アプリの動画撮って保存して、Keynoteに貼り付けるとかしないといけない。", style = SlideTypography.body1)
            }
        }
    }
}

@SlidePreview
@Composable
private fun PreviewPros1() {
    Pros1()
}

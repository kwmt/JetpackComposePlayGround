package net.kwmt27.jetpackcomposeplayground.slide.contents.shibuyaapk43

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.kwmt27.jetpackcomposeplayground.slide.SlidePreview
import net.kwmt27.jetpackcomposeplayground.slide.SlideTypography
import net.kwmt27.jetpackcomposeplayground.slide.components.SlideBase

internal const val PROS4_SUB_TITLE = "AndroidなのでAndroidでできることはできる"

@Composable
internal fun Pros4() {
    SlideBase(
        title = "Pros",
        subTitle = PROS4_SUB_TITLE
    ) {
        Column {
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = "たとえば、ランダムな画像をスライド一杯に並べる、とか",
                style = SlideTypography.body1
            )
        }
    }
}

@SlidePreview
@Composable
private fun PreviewPros1() {
    Pros4()
}

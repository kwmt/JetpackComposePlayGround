package net.kwmt27.jetpackcomposeplayground.slide.contents.shibuyaapk43

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import net.kwmt27.jetpackcomposeplayground.slide.SlidePreview
import net.kwmt27.jetpackcomposeplayground.slide.SlideTypography
import net.kwmt27.jetpackcomposeplayground.slide.components.SlideBase

@Composable
internal fun Pros4() {
    SlideBase(
        title = "Pros",
        subTitle = "プログラムなのである程度なんでもつくれる"
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

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

internal const val CONS1_SUB_TITLE = "スライドのコードを書く必要がある"

@Composable
internal fun Cons1() {
    SlideBase(
        title = "デメリット",
        subTitle = CONS1_SUB_TITLE
    ) {
        Column {
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = "Keynoteにあるような機能はもちろん使えない",
                style = SlideTypography.body1
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = "かっこいいトランジションが使えなかったり",
                style = SlideTypography.body1
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = "発表中のメモがみれなかったり",
                style = SlideTypography.body1
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = "だが、実装すればいい！",
                style = SlideTypography.body1
            )
        }
    }
}

@SlidePreview
@Composable
private fun PreviewPros() {
    Cons1()
}

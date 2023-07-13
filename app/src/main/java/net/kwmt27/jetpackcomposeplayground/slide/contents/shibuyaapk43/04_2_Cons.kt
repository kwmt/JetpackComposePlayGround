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

internal const val CONS2_SUB_TITLE = "コードのリファクタリングに集中しすぎて、スライド作成の時間がなくなることがある"

@Composable
internal fun Cons2() {
    SlideBase(
        title = "Cons",
        subTitle = CONS2_SUB_TITLE
    ) {
        Column {
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = "ご利用は計画的に。",
                style = SlideTypography.body1
            )
        }
    }
}

@SlidePreview
@Composable
private fun PreviewPros() {
    Cons2()
}

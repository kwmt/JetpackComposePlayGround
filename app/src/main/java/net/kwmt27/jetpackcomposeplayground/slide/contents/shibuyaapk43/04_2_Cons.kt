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

internal const val CONS3_SUB_TITLE = "スライドをシェアするのが若干面倒"
@Composable
internal fun Cons2() {
    SlideBase(
        title = "デメリット",
        subTitle = CONS3_SUB_TITLE
    ) {
        Column {
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = "Speaker Deckやconnpassに登録しにくい",
                style = SlideTypography.body1
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = "→ PDFにExportできる機能を実装すれば解決するかも？",
                style = SlideTypography.body1
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = "Play Storeに上げる？",
                style = SlideTypography.body1
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = "→Full HDに最適化してるので、スマホでは見れない",
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

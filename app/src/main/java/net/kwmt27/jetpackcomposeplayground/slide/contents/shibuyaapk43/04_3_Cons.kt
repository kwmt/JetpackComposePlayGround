package net.kwmt27.jetpackcomposeplayground.slide.contents.shibuyaapk43

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import net.kwmt27.jetpackcomposeplayground.slide.SlidePreview
import net.kwmt27.jetpackcomposeplayground.slide.SlideTypography
import net.kwmt27.jetpackcomposeplayground.slide.components.SlideBase

@Composable
internal fun Cons3() {
    SlideBase(
        title = "Cons",
        subTitle = "スライドをシェアするのが若干面倒"
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
    Cons3()
}

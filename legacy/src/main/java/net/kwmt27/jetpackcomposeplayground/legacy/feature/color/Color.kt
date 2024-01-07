package net.kwmt27.jetpackcomposeplayground.legacy.feature.color

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ColorToArgbSample() {
    val Neutral8 = Color(0xff121212)
    val Neutral7 = Color(0xdef000000)
    val Neutral6 = Color(0x99000000)
    val Neutral5 = Color(0x61000000)
    val Neutral4 = Color(0x1f000000)
    val Neutral3 = Color(0x1fffffff)
    val Neutral2 = Color(0x61ffffff)
    val Neutral1 = Color(0xbdffffff)
    val Neutral0 = Color(0xffffffff)

    Log.d("tag", Neutral8.toArgb().toString())
}

@Preview
@Composable
fun PreviewColorToArgbSample() {
    ColorToArgbSample()
}

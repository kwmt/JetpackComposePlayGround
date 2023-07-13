package net.kwmt27.jetpackcomposeplayground.slide.contents.shibuyaapk43

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.kwmt27.jetpackcomposeplayground.chart.PieChartScreen
import net.kwmt27.jetpackcomposeplayground.slide.SlidePreview
import net.kwmt27.jetpackcomposeplayground.slide.SlideTypography
import net.kwmt27.jetpackcomposeplayground.slide.components.SlideBase

internal const val PROS2_SUB_TITLE = "コードをさわりながらスライドが作れる"
@Composable
internal fun Pros2() {
    SlideBase(
        title = "Pros",
        subTitle = PROS2_SUB_TITLE
    ) {
        Row {
            Column {
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = "たとえばチャートってどうやって書くんだろう？",
                    style = SlideTypography.body1
                )
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = "「Keynote チャート 使い方」で検索するのではなく",
                    style = SlideTypography.body1
                )
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = "「Compose chart」で検索できる",
                    style = SlideTypography.body1
                )
                Spacer(modifier = Modifier.size(64.dp))
                Text(
                    text = "つまり",
                    style = SlideTypography.body1
                )
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = "スライドを作りながら成長ができる",
                    style = SlideTypography.body1
                )
            }
            PieChartScreen()
        }
    }
}

@SlidePreview
@Composable
private fun PreviewPros1() {
    Pros2()
}

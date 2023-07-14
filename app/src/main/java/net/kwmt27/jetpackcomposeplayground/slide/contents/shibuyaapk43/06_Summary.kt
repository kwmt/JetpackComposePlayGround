package net.kwmt27.jetpackcomposeplayground.slide.contents.shibuyaapk43

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.kwmt27.jetpackcomposeplayground.slide.SlidePreview
import net.kwmt27.jetpackcomposeplayground.slide.SlideTypography
import net.kwmt27.jetpackcomposeplayground.slide.components.SlideBase

@Composable
fun Summary() {
    SlideBase("まとめ") {
        Row(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column {
                Text(
                    text = "「スライドをAndroidアプリとして作る」方法についてご紹介しました。",
                    style = SlideTypography.body1
                )
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = "この方法はスライドのコードを書く必要があるため、手間がかかることや、スライドをシェアする際に若干の面倒。",
                    style = SlideTypography.body1
                )
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = "しかし、Android好きでコード書きたくて発表もしたい皆さんであれば、スライドアプリを作成するという方法に挑戦してみてはいかがでしょうか！",
                    style = SlideTypography.body1
                )
            }
        }
    }
}

@SlidePreview
@Composable
private fun PreviewSummary() {
    Summary()
}

package net.kwmt27.jetpackcomposeplayground.slide.contents.shibuyaapk43

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.kwmt27.jetpackcomposeplayground.animation.AutoRollingTextSample
import net.kwmt27.jetpackcomposeplayground.slide.SlidePreview
import net.kwmt27.jetpackcomposeplayground.slide.SlideTypography
import net.kwmt27.jetpackcomposeplayground.slide.components.Code
import net.kwmt27.jetpackcomposeplayground.slide.components.SlideBase

@Composable
internal fun Pros2() {
    SlideBase(
        title = "Pros",
        subTitle = "コードをさわりながらスライドが作れる"
    ) {
        Row {
            Column {
                Text(
                    text = "Keynote",
                    style = SlideTypography.h3
                )
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = "コード触りたいのに keynoteの使い方などをググりながら作ることになるため、keynoteの使い方を知りたいんじゃない、Androidアプリの知識を得たいんだ。keynoteの使い方を調べてる暇があるならAndroidのコードを書きたい！⇛それができる",
                    style = SlideTypography.body1
                )
            }
        }
    }
}

@SlidePreview
@Composable
private fun PreviewPros1() {
    Pros2()
}

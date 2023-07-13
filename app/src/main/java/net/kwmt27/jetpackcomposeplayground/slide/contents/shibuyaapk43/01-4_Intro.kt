package net.kwmt27.jetpackcomposeplayground.slide.contents.shibuyaapk43

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.kwmt27.jetpackcomposeplayground.slide.SlidePreview
import net.kwmt27.jetpackcomposeplayground.slide.SlideTypography
import net.kwmt27.jetpackcomposeplayground.slide.components.SlideBase

@Composable
fun Intro4() {
    SlideBase("いきなりですが質問です！") {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text("Android好きですよね？", style = SlideTypography.h3)
            Spacer(modifier = Modifier.size(16.dp))
            Text("コード書きたいですよね？", style = SlideTypography.h3)
            Spacer(modifier = Modifier.size(16.dp))
            Text("発表もしたいですよね？", style = SlideTypography.h3)
            Spacer(modifier = Modifier.size(32.dp))
            Text("そんなあなたにオススメな方法をご紹介", style = SlideTypography.h3)
        }
    }
}

@SlidePreview
@Composable
private fun PreviewIntro3() {
    Intro3()
}

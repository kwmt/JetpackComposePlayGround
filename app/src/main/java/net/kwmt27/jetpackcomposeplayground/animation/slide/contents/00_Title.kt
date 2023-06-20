package net.kwmt27.jetpackcomposeplayground.animation.slide.contents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import net.kwmt27.jetpackcomposeplayground.animation.slide.SlideTypography

@Composable
fun SlideTitle() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("LIPSでのJetpack Composeアニメーション実装事例",  style = SlideTypography.h1)
        Text("potatotips #82", style = SlideTypography.body1)
    }
}

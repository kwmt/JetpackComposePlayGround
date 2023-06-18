package net.kwmt27.jetpackcomposeplayground.animation.slide.contents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import net.kwmt27.jetpackcomposeplayground.animation.slide.components.ASSET_BASE_PATH
import net.kwmt27.jetpackcomposeplayground.animation.slide.components.SlideImage

@Composable
fun Intro2() {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        SlideImage(data = "${ASSET_BASE_PATH}giphy.gif")

        Column {
            Text("テキストが下から上に回転するようなアニメーション")
            Text("テキストが下から上に回転するようなアニメーション")
            Text("テキストが下から上に回転するようなアニメーション")
        }
    }
}

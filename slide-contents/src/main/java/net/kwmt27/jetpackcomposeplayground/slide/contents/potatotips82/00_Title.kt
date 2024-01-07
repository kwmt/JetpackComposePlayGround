package net.kwmt27.jetpackcomposeplayground.slide.contents.potatotips82

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.github.kwmt.slide.components.SlideBase
import com.github.kwmt.slide.ui.theme.SlideTypography

@Composable
internal fun SlideTitle() {
    SlideBase {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text("LIPSでのJetpack Composeアニメーション実装事例", style = SlideTypography.h1)
            Text("potatotips #82", style = SlideTypography.body1)
        }
    }
}

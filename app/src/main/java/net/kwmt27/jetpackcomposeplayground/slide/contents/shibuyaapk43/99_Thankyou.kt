package net.kwmt27.jetpackcomposeplayground.slide.contents.shibuyaapk43

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.kwmt.slide.components.SlideBase
import com.github.kwmt.slide.ui.theme.SlidePreview
import com.github.kwmt.slide.ui.theme.SlideTypography

@Composable
fun ThankYou() {
    SlideBase {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text("Thank You!", style = SlideTypography.h1)
            Text("ありがとうございました", style = SlideTypography.h1)
            Spacer(modifier = Modifier.size(16.dp))
            Text("@yasi_kawamoto", style = SlideTypography.body1)
        }
    }
}

@SlidePreview
@Composable
private fun PreviewThankYou() {
    ThankYou()
}

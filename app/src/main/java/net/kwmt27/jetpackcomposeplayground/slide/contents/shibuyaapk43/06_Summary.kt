package net.kwmt27.jetpackcomposeplayground.slide.contents.shibuyaapk43

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
fun Summary() {
    SlideBase("まとめ") {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                Text(
                    text = "Pros",
                    style = SlideTypography.h3
                )
                Spacer(modifier = Modifier.size(16.dp))

                listOf(PROS1_SUB_TITLE, PROS2_SUB_TITLE, PROS3_SUB_TITLE, PROS4_SUB_TITLE).forEach {
                    Text(
                        text = it,
                        style = SlideTypography.body1
                    )
                    Spacer(modifier = Modifier.size(16.dp))
                }
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = "Cons",
                    style = SlideTypography.h3
                )
                Spacer(modifier = Modifier.size(16.dp))

                listOf(CONS1_SUB_TITLE, CONS2_SUB_TITLE, CONS3_SUB_TITLE).forEach {
                    Text(
                        text = it,
                        style = SlideTypography.body1
                    )
                    Spacer(modifier = Modifier.size(16.dp))
                }
            }
        }
    }
}

@SlidePreview
@Composable
private fun PreviewSummary() {
    Summary()
}

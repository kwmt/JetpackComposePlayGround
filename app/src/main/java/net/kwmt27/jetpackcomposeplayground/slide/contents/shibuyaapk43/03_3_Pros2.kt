package net.kwmt27.jetpackcomposeplayground.slide.contents.shibuyaapk43

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import net.kwmt27.jetpackcomposeplayground.slide.SlidePreview
import net.kwmt27.jetpackcomposeplayground.slide.SlideTypography
import net.kwmt27.jetpackcomposeplayground.slide.components.Code
import net.kwmt27.jetpackcomposeplayground.slide.components.SlideBase

@Composable
internal fun Pros3_2() {
    SlideBase(
        title = "Pros",
        subTitle = PROS3_SUB_TITLE
    ) {
        Column {
            Row {
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = "ハードウェアキーボード入力イベントの実装ってどうやるの？",
                    style = SlideTypography.body1
                )
                Spacer(modifier = Modifier.size(16.dp))
                Code(path = "shibuyaapk43_03_3_Pros2_1.html")
            }
            Spacer(modifier = Modifier.size(16.dp))

            Text(
                text = "ClickableなComposableにマウスでホバーすると、色がかわるのですが、それを無効化したいときどうするんだ？とか",
                style = SlideTypography.body1
            )
            Spacer(modifier = Modifier.size(64.dp))

            Row {
                HoverSample()
                Spacer(modifier = Modifier.size(16.dp))
                HoverDisableSample()

                Spacer(modifier = Modifier.size(32.dp))
                Code(path = "shibuyaapk43_03_3_Pros2_2.html")
            }
        }
    }
}

@Composable
private fun HoverSample() {
    Box(
        modifier = Modifier
            .size(200.dp)
            .clip(CircleShape)
            .background(Color.Green)
            .clickable {}
    )
}

@Composable
private fun HoverDisableSample() {
    Box(
        modifier = Modifier
            .size(200.dp)
            .clip(CircleShape)
            .background(Color.Green)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
            ) {}
    )
}

@SlidePreview
@Composable
private fun PreviewPros1() {
    Pros3_2()
}

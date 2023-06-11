package net.kwmt27.jetpackcomposeplayground.animation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AutoRollingTextSample() {
    Column(modifier = Modifier.fillMaxWidth()) {
        AutoRollingTextSample1()
        AutoRollingTextSample2()
        AutoRollingTextSample3()
    }
}

@Composable
private fun AutoRollingTextSample1() {
    AutoRollingTextSampleBaseWithAddButton {
        AutoRollingTextSampleBase {
            AnimatedContent1(count = it)
        }
    }
}

@Composable
private fun AutoRollingTextSample2() {
    AutoRollingTextSampleBaseWithAddButton {
        AutoRollingTextSampleBase {
            AnimatedContent2(count = it)
        }
    }
}

@Composable
private fun AutoRollingTextSample3() {
    AutoRollingTextSampleBaseWithAddButton {
        BoxBase {
            AutoRollingTextSampleBase {
                AnimatedContent2(count = it)
            }
        }
    }
}

@Composable
private fun AutoRollingTextSampleBaseWithAddButton(
    content: @Composable (Int) -> Unit,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        var count: Int by remember { mutableStateOf(0) }

        content(count)

        Button(onClick = { count++ }, modifier = Modifier.padding(horizontal = 16.dp)) {
            Text("Add")
        }
    }
}

@Composable
private fun AutoRollingTextSampleBase(
    content: @Composable () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF2F2F2))
            .padding(16.dp),
    ) {
        content()
    }
}

/**
 * AnimatedContent デフォルトアニメーション
 */
@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun AnimatedContent1(count: Int) {
    AnimatedContent(targetState = count, label = "Auto rolling tet") { targetCount ->
        Text(text = "Count: $targetCount", fontSize = 24.sp)
    }
}

/**
 * ローリングアニメーション
 */
@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun AnimatedContent2(count: Int) {
    AnimatedContent(
        targetState = count,
        label = "Auto rolling tet",
        transitionSpec = {
            if (targetState > initialState) {
                slideInVertically { height -> height } + fadeIn() with
                        slideOutVertically { height -> -height } + fadeOut()
            } else {
                slideInVertically { height -> -height } + fadeIn() with
                        slideOutVertically { height -> height } + fadeOut()
            }.using(
                SizeTransform(clip = false)
            )
        }
    ) { targetCount ->
        Text(text = "Count: $targetCount", fontSize = 24.sp)
    }
}

@Composable
fun LipsAIButtonLayout() {
}

@Composable
fun BoxBase(
    content: @Composable () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(horizontal = 16.dp)
            .clip(CircleShape)
            .background(Color(0xFFF2F2F2)),
        contentAlignment = Alignment.CenterStart,
    ) {
        content()
    }
}

@Composable
private fun ImageSample() {
    Box(modifier = Modifier
        .size(56.dp)
        .clip(CircleShape))
}

@Preview
@Composable
fun PreviewBoxBase() {
    AutoRollingTextSample()
}

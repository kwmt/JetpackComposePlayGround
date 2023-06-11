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
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
        AutoRollingTextSample0()
        AutoRollingTextSample1()
        AutoRollingTextSample2()
        AutoRollingTextSample3()
    }
}

@Composable
private fun AutoRollingTextSample0() {
    AutoRollingTextSampleBaseWithAddButton { count, isVisible ->
        ButtonLayout(isVisible = isVisible) {
            AnimatedContent0(count = count)
        }
    }
}

@Composable
private fun AutoRollingTextSample1() {
    AutoRollingTextSampleBaseWithAddButton { count, isVisible ->
        ButtonLayout(isVisible = isVisible) {
            AnimatedContent1(count = count)
        }
    }
}

@Composable
private fun AutoRollingTextSample2() {
    AutoRollingTextSampleBaseWithAddButton { count, isVisible ->
        ButtonLayout(isVisible = isVisible) {
            AnimatedContent2(count = count)
        }
    }
}

@Composable
private fun AutoRollingTextSample3() {
    AutoRollingTextSampleBaseWithAddButton { count, isVisible ->
        ButtonLayout(isVisible = isVisible) {
            AnimatedContent2(count = count)
        }
    }
}

@Composable
private fun AutoRollingTextSampleBaseWithAddButton(
    content: @Composable (Int, Boolean) -> Unit,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        var count: Int by remember { mutableStateOf(0) }

        content(count, count != 4)

        Row() {
            Button(onClick = { count++ }, modifier = Modifier.padding(horizontal = 16.dp)) {
                Text("Add")
            }

            Button(onClick = { count = 0 }) {
                Text("Clear")
            }
        }
    }
}

/**
 * AnimatedContent デフォルトアニメーション
 */
@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun AnimatedContent0(count: Int) {
    Text(text = "Count: $count", fontSize = 24.sp)
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
fun ButtonLayout(
    isVisible: Boolean,
    content: @Composable () -> Unit,
) {
    BoxBase {
        if (isVisible) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFF2F2F2))
                    .padding(start = 16.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                content()
            }
        }
        val color = if (isVisible) Color.Blue else Color.Red
        ImageSample(color = color, Modifier.align(Alignment.CenterEnd))
    }
}

@Composable
fun BoxBase(
    content: @Composable BoxScope.() -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(horizontal = 16.dp)
            .clip(CircleShape),
        contentAlignment = Alignment.CenterStart,
    ) {
        content()
    }
}

@Composable
private fun ImageSample(color: Color, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(80.dp)
            .clip(CircleShape)
            .background(color)
    )
}

@Preview
@Composable
fun PreviewAutoRollingTextSample() {
    AutoRollingTextSample()
}


package net.kwmt27.jetpackcomposeplayground.animation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import kotlinx.coroutines.delay

@Composable
fun AutoRollingTextSample() {
    Column() {
        AutoRollingTextSample0()
        AutoRollingTextSample1()
        AutoRollingTextSample2()
        AutoRollingTextSample3()
        AutoRollingTextSample4()
        AutoRollingTextSample5()
    }
}

@Composable
fun AutoRollingTextSample0() {
    AutoCountUp { count, isVisible ->
        ButtonLayout1NoAnimation(isVisible = isVisible) {
            AnimatedContent0(count = count)
        }
    }
}

@Composable
fun AutoRollingTextSample1() {
    AutoCountUp { count, isVisible ->
        ButtonLayout1NoAnimation(isVisible = isVisible) {
            AnimatedContent1(count = count)
        }
    }
}

@Composable
private fun AutoRollingTextSample2() {
    AutoCountUp { count, isVisible ->
        ButtonLayout1NoAnimation(isVisible = isVisible) {
            AnimatedContent2(count = count)
        }
    }
}

@Composable
private fun AutoRollingTextSample3() {
    AutoCountUp { count, isVisible ->
        ButtonLayout2BoxContentDefaultAnimation(isVisible = isVisible) {
            AnimatedContent2(count = count)
        }
    }
}

@Composable
private fun AutoRollingTextSample4() {
    AutoCountUp { count, isVisible ->
        ButtonLayout3BoxContentShrinkAnimation(isVisible = isVisible) {
            AnimatedContent2(count = count)
        }
    }
}

@Composable
fun AutoRollingTextSample5() {
    AutoCountUp { count, isVisible ->
        ButtonLayout4BoxContentShrinkAndImageCrossFadeAnimation(isVisible = isVisible) {
            AnimatedContent2(count = count)
        }
    }
}

// ---------------------------------------------
@Composable
private fun AnimatedContent0(count: Int) {
    Text(text = "Count: $count", fontSize = 24.sp)
}

/**
 * AnimatedContent デフォルトアニメーション
 */
@Composable
private fun AnimatedContent1(count: Int) {
    AnimatedContent(targetState = count, label = "AnimatedContent1") { targetCount ->
        Text(text = "Count: $targetCount", fontSize = 24.sp)
    }
}

/**
 * ローリングアニメーション
 */
@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun AnimatedContent2(count: Int) {
    AnimatedContent(targetState = count, label = "AnimatedContent2", transitionSpec = {
        if (targetState > initialState) {
            slideInVertically { height -> height } + fadeIn() with slideOutVertically { height -> -height } + fadeOut()
        } else {
            slideInVertically { height -> -height } + fadeIn() with slideOutVertically { height -> height } + fadeOut()
        }.using(
            SizeTransform(clip = false)
        )
    }) { targetCount ->
        Text(text = "Count: $targetCount", fontSize = 24.sp)
    }
}

@Composable
private fun ButtonLayout1NoAnimation(
    isVisible: Boolean,
    content: @Composable () -> Unit,
) {
    BoxBase {
        if (isVisible) {
            BoxContent {
                content()
            }
        }
        val color = if (isVisible) Color.Blue else Color.Red
        ImageSample(color = color, Modifier.align(Alignment.CenterEnd))
    }
}

@Composable
private fun ButtonLayout2BoxContentDefaultAnimation(
    isVisible: Boolean,
    content: @Composable () -> Unit,
) {
    BoxBase {
        AnimatedVisibility(visible = isVisible) {
            BoxContent {
                content()
            }
        }
        val color = if (isVisible) Color.Blue else Color.Red
        ImageSample(color = color, Modifier.align(Alignment.CenterEnd))
    }
}

@Composable
private fun ButtonLayout3BoxContentShrinkAnimation(
    isVisible: Boolean,
    content: @Composable () -> Unit,
) {
    BoxBase {
        AnimatedVisibility(
            visible = isVisible,
            exit = shrinkHorizontally(tween(ANIMATION_DURATION_MILLS)) +
                    fadeOut(tween(ANIMATION_DURATION_MILLS)),
        ) {
            BoxContent {
                content()
            }
        }
        val color = if (isVisible) Color.Blue else Color.Red
        ImageSample(color = color, Modifier.align(Alignment.CenterEnd))
    }
}

@Composable
private fun ButtonLayout4BoxContentShrinkAndImageCrossFadeAnimation(
    isVisible: Boolean,
    content: @Composable () -> Unit,
) {
    BoxBase {
        AnimatedVisibility(
            visible = isVisible,
            exit = shrinkHorizontally(tween(ANIMATION_DURATION_MILLS)) +
                    fadeOut(tween(ANIMATION_DURATION_MILLS)),
        ) {
            BoxContent {
                content()
            }
        }
        val color = if (isVisible) Color.Blue else Color.Red
        Crossfade(
            targetState = color,
            animationSpec = tween(ANIMATION_DURATION_MILLS),
            label = "CrossfadeImage"
        ) {
            ImageSample(color = it, Modifier.align(Alignment.CenterEnd))
        }
    }
}

// ---------------------------------------------
@Composable
private fun AutoCountUp(
    content: @Composable (Int, Boolean) -> Unit,
) {
    var count: Int by remember { mutableIntStateOf(0) }

    if (count < 4) {
        LaunchedEffect(key1 = count) {
            delay(ANIMATION_DURATION_MILLS.toLong())
            count++
        }
    }
    Column(
        modifier = Modifier
            .width(500.dp)
            .clickable(
                // desktop appでのhover無効化
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
            ) { count = 0 }
            .padding(16.dp)
    ) {
        content(count, count < 4)
    }
}

@Composable
private fun BoxContent(
    content: @Composable () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
            .padding(start = 16.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        content()
    }
}

@Composable
private fun BoxBase(
    content: @Composable BoxScope.() -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(horizontal = 16.dp)
            .clip(CircleShape),
        // shrinkHorizontallyで右にアニメーションさせるのに必要な設定
        contentAlignment = Alignment.CenterEnd,
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
private fun PreviewAutoRollingTextSample() {
    AutoRollingTextSample()
}

private const val ANIMATION_DURATION_MILLS = 1500

package net.kwmt27.jetpackcomposeplayground.animation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val Orange = Color(0xffffa500)

@Composable
fun AnimateAsStateDemo() {
    var blue by remember { mutableStateOf(true) }
    val color by animateColorAsState(if (blue) Blue else Orange)
//    val color = if (blue) Blue else Orange
    Column {
        Button(onClick = { blue = !blue }) {
            Text(text = "CHANGE COLOR")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .size(128.dp)
                .background(color)
        )
    }
}

@Composable
@Preview
fun PreviewAnimateAsStateDemo() {
    AnimateAsStateDemo()
}

private enum class BoxState {
    Small,
    Large
}

@Composable
fun UpdateTransitionDemo() {
    var boxState by remember { mutableStateOf(BoxState.Small) }
    val transition = updateTransition(targetState = boxState, label = "boxState")
    val color by transition.animateColor(label = "color") { state ->
        when (state) {
            BoxState.Small -> Blue
            BoxState.Large -> Orange
        }
    }
    val size by transition.animateDp(
        transitionSpec = {
            if (targetState == BoxState.Large) {
                tween(durationMillis = 500)
            } else {
                tween(durationMillis = 200)
            }
        }, label = "size"
    ) { state ->
        when (state) {
            BoxState.Small -> 64.dp
            BoxState.Large -> 128.dp
        }
    }

    Column {
        Button(onClick = {
            boxState = when (boxState) {
                BoxState.Small -> BoxState.Large
                BoxState.Large -> BoxState.Small
            }
        }) {
            Text(text = "CHANGE COLOR AND SIZE")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .size(size)
                .background(color)
        )
    }
}

@Composable
@Preview
fun PreviewUpdateTransitionDemo() {
    UpdateTransitionDemo()
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedVisibilityDemo() {
    var visible by remember { mutableStateOf(true) }
    Column {
        Button(
            onClick = { visible = !visible }
        ) {
            Text(text = if (visible) "HIDE" else "SHOW")
        }
        Spacer(modifier = Modifier.height(16.dp))

        AnimatedVisibility(visible) {
            Box(
                modifier = Modifier
                    .size(128.dp)
                    .background(Blue)
            )
        }
    }
}

@Preview
@Composable
fun PreviewAnimatedVisibilityDemo() {
    AnimatedVisibilityDemo()
}

@Composable
fun AnimatedContentSizeDemo() {
    var expanded by remember { mutableStateOf(false) }
    Column {
        Button(
            onClick = { expanded = !expanded }
        ) {
            Text(text = if (expanded) "SHRINK" else "EXPAND")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .background(Color.LightGray)
                .animateContentSize()
        ) {
            Text(
                text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                fontSize = 16.sp,
                textAlign = TextAlign.Justify,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(16.dp),
                maxLines = if (expanded) Int.MAX_VALUE else 2
            )
        }
    }
}

@Preview
@Composable
fun PreviewAnimatedContentSizeDemo() {
    AnimatedContentSizeDemo()
}

private enum class DemoScene {
    Text,
    Icon
}

@Composable
fun CrossFadeDemo() {
    var scene by remember { mutableStateOf(DemoScene.Text) }

    Column {
        Button(
            onClick = {
                scene = when (scene) {
                    DemoScene.Text -> DemoScene.Icon
                    DemoScene.Icon -> DemoScene.Text
                }
            }
        ) {
            Text(text = "TOGGLE")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Crossfade(targetState = scene) { scene ->
            when (scene) {
                DemoScene.Text -> Text(
                    text = "Phone",
                    fontSize = 32.sp
                )
                DemoScene.Icon -> Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = null,
                    modifier = Modifier.height(48.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewCrossFadeDemo() {
    CrossFadeDemo()
}

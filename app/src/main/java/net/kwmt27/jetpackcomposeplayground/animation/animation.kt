package net.kwmt27.jetpackcomposeplayground.animation

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Colors
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
    val color = when (boxState) {
        BoxState.Small -> Blue
        BoxState.Large -> Orange
    }
    val size = when (boxState) {
        BoxState.Small -> 64.dp
        BoxState.Large -> 128.dp
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
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
//    val color by animateColorAsState(if (blue) Blue else Orange)
    val color = if (blue) Blue else Orange
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
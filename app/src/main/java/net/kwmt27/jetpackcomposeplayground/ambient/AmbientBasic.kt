package net.kwmt27.jetpackcomposeplayground.ambient

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Providers
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.tooling.preview.Preview

private val LocalCounter = compositionLocalOf<Int>()

@Composable
private fun Parent() {
    val count = 100
    Providers(LocalCounter provides count) {
        Child()
    }
}

@Composable
private fun Child() {
    val count = LocalCounter.current
    Text("Count value $count")
}

@Preview
@Composable
private fun PreviewParent() {
    Parent()
}
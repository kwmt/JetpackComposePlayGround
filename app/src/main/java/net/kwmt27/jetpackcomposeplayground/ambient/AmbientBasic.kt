package net.kwmt27.jetpackcomposeplayground.ambient

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Providers
import androidx.compose.runtime.ambientOf
import androidx.compose.ui.tooling.preview.Preview

private val AmbientCounter = ambientOf<Int>()

@Composable
private fun Parent() {
    val count = 100
    Providers(AmbientCounter provides count) {
        Child()
    }
}

@Composable
private fun Child() {
    val count = AmbientCounter.current
    Text("Count value $count")
}

@Preview
@Composable
private fun PreviewParent() {
    Parent()
}
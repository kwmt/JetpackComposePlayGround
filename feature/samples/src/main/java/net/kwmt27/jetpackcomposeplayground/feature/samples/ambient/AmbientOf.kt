package net.kwmt27.jetpackcomposeplayground.feature.samples.ambient

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Child(text: String) {
    Log.d("CompositionLocalTest", "Child: $text")
    Text("Count value $text")
}

private val LocalCounter = staticCompositionLocalOf<Int> {
    error("")
}

@Composable
private fun Parent() {
    val count = remember { mutableStateOf(0) }

    CompositionLocalProvider(LocalCounter provides count.value) {
        val ambientString = "Ambient Text, Counter ${LocalCounter.current}"
        Column() {
            Child(text = ambientString)
            Child(text = "Unchanged text")
            IconButton(onClick = { count.value++ }) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = null
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewParent() {
    Parent()
}

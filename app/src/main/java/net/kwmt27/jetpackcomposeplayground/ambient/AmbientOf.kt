package net.kwmt27.jetpackcomposeplayground.ambient

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Child(text: String) {
    Log.d("AmbientTest", "Child: $text")
    Text("Count value $text")
}


private val AmbientCounter = staticAmbientOf<Int>()


@Composable
private fun Parent() {
    val count = remember { mutableStateOf(0) }

    Providers(AmbientCounter provides count.value) {
        val ambientString = "Ambient Text, Counter ${AmbientCounter.current}"
        Column() {
            Child(text = ambientString)
            Child(text = "Unchanged text")
            IconButton(onClick = { count.value++ }) {
                Icon(Icons.Default.Add)
            }

        }

    }

}

@Preview
@Composable
private fun PreviewParent() {
    Parent()
}
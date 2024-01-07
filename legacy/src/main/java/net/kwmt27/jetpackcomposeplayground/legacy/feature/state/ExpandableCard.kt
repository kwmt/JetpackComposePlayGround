package net.kwmt27.jetpackcomposeplayground.legacy.feature.state

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ExpandableCardSample() {
    ExpandingCard(
        "hello",
        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    )
}

@Composable
fun ExpandingCard(title: String, body: String) {
    var expanded by remember { mutableStateOf(false) }

    Card {
        Column(
            Modifier
                .width(280.dp)
                .animateContentSize()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
        ) {
            Text(text = title)
            if (expanded) {
                Text(text = body, Modifier.padding(top = 8.dp))
                IconButton(onClick = { expanded = false }, modifier = Modifier.fillMaxWidth()) {
                Icon(Icons.Default.MoreVert, contentDescription = null)
            }
            } else {
                IconButton(onClick = { expanded = true }, modifier = Modifier.fillMaxWidth()) {
                Icon(Icons.Default.Face, contentDescription = null)
            }
            }
        }
    }
}

@Composable
@Preview
fun PreviewExpandingCard() {
    ExpandableCardSample()
}

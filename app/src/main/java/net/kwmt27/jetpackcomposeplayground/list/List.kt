package net.kwmt27.jetpackcomposeplayground.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.kwmt27.jetpackcomposeplayground.ui.theme.JetpackComposePlayGroundTheme

@Composable
fun SampleVerticalList() {
    LazyColumn {
        items(5) { index ->
            ListItem(index)
        }
    }
}


@Composable
fun ListItem(index: Int = 0) {
    Column {
        Box(
            modifier = Modifier
                .height(200.dp)
                .background(Color.Blue)
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "index: $index",
                style = TextStyle(color = Color.White)
            )
        }
        Divider(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun SampleHorizontalList() {
    LazyRow{
        items(5) { index ->
            ListHorizontalItem(index)
        }
    }
}

@Composable
fun ListHorizontalItem(index: Int = 0) {
    Column {
        Box(
            modifier = Modifier
                .width(200.dp)
                .background(Color.Blue)
                .height(200.dp)
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "index: $index",
                style = TextStyle(color = Color.White)
            )
        }
        Divider(modifier = Modifier.height(8.dp))
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun PreviewSampleList() {
    JetpackComposePlayGroundTheme {
        SampleVerticalList()
    }
}
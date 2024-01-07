package net.kwmt27.jetpackcomposeplayground.feature.samples.box

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BoxSample() {
    Box {
        // グレーの四角(縦横100dp)
        Spacer(
            modifier = Modifier
                .background(Color.Gray)
                .size(100.dp)
        )

        // ブルーの四角(縦横50dp)
        Box(
            modifier = Modifier
                .size(50.dp)
                .offset(x = 10.dp, y = 10.dp)
                .background(Color.Blue),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "test",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
                    .background(Color.Red),
                textAlign = TextAlign.Center,
                style = TextStyle(color = Color.White),
            )
        }
    }
}

@Preview
@Composable
fun PreviewBoxSample() {
    BoxSample()
}

package net.kwmt27.jetpackcomposeplayground.image

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.coil.CoilImage

@Composable
fun NetworkImageSample(
) {
    CoilImage(
        data = "https://picsum.photos/300/300",
        contentDescription = null,
    )
}

@Preview
@Composable
fun PreviewNetworkImageSample() {
    NetworkImageSample()
}

@Composable
fun CircleImageSample() {
    Surface(
        shape = CircleShape,
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
    ) {
        CoilImage(
            data = "https://picsum.photos/300/300",
            contentDescription = null,
        )
    }
}

@Preview
@Composable
fun PreviewCircleImageSample() {
    CircleImageSample()
}
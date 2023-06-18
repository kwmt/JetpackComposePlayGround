package net.kwmt27.jetpackcomposeplayground.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun NetworkImageSample() {
    AsyncImage(
        model = ImageRequest
            .Builder(LocalContext.current)
            .data("https://picsum.photos/300/300")
            .crossfade(true)
            .build(),
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
        AsyncImage(
            model = ImageRequest
                .Builder(LocalContext.current)
                .data("https://picsum.photos/300/300")
                .crossfade(true)
                .build(),
            contentDescription = null,
        )
    }
}

@Preview
@Composable
fun PreviewCircleImageSample() {
    CircleImageSample()
}

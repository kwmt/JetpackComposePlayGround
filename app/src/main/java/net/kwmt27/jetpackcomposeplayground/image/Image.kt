package net.kwmt27.jetpackcomposeplayground.image

import androidx.compose.runtime.Composable
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
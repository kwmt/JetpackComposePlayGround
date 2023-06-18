package net.kwmt27.jetpackcomposeplayground.animation.slide

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import net.kwmt27.jetpackcomposeplayground.R

@Composable
internal fun SlideContent(slide: Slide) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = slide.title)
        Text(text = slide.content)
        SlideImage(R.drawable.animation_flowchart)
    }
}

@Composable
internal fun SlideImage(
    data: Any?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit,
) {
    AsyncImage(
        model = ImageRequest
            .Builder(LocalContext.current)
            .data(data)
            .crossfade(true)
            .build(),
        contentDescription = null,
        modifier = modifier,
        contentScale = contentScale,
    )
}

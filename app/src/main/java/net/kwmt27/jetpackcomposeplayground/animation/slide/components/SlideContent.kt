package net.kwmt27.jetpackcomposeplayground.animation.slide.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.kwmt27.jetpackcomposeplayground.animation.slide.Slide
import net.kwmt27.jetpackcomposeplayground.animation.slide.SlideTypography

@Composable
internal fun SlideContent(slide: Slide) {
    val (verticalArrangement, horizontalAlignment) = if (slide.title != null) Arrangement.Top to Alignment.Start else {
        Arrangement.Center to Alignment.CenterHorizontally
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 24.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
        verticalArrangement = verticalArrangement,
        horizontalAlignment = horizontalAlignment,
    ) {
        if (slide.title != null) {
            Text(text = slide.title, style = SlideTypography.h2)
        }
        Box(modifier = Modifier.padding(16.dp)) {
            slide.content()
        }
    }
}

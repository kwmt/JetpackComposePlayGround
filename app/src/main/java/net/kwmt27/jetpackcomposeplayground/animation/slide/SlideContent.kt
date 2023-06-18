package net.kwmt27.jetpackcomposeplayground.animation.slide

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
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
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState

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

@SuppressLint("SetJavaScriptEnabled")
@Composable
internal fun Code(
    path: String,
) {
    val webViewState = rememberWebViewState(
        url = "file:///android_asset/$path",
    )
    WebView(
        state = webViewState,
        onCreated = {
            it.settings.run {
                javaScriptEnabled = true
                allowContentAccess = true
                useWideViewPort = true
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 1.dp), // A bottom sheet can't support content with 0 height.
        captureBackPresses = false,
    )
}

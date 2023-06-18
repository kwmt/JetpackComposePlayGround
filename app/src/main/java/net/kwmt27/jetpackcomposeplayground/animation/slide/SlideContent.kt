package net.kwmt27.jetpackcomposeplayground.animation.slide

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
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
//        SlideImage(R.drawable.animation_flowchart)
        Code("animated_content.html")
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

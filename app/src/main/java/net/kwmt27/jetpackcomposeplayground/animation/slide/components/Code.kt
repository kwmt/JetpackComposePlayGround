package net.kwmt27.jetpackcomposeplayground.animation.slide.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState

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

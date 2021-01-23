package net.kwmt27.jetpackcomposeplayground.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.graphics.luminance

interface SystemUiController {
    fun setStatusBarColor(
        color: Color,
        darkIcons: Boolean = color.luminance() > 0.5f,
        transformColorForLightContent: (Color) -> Color = BlackScrimmed
    )
}

private val BlackScrim = Color(0f, 0f, 0f, 0.2f)
private val BlackScrimmed: (Color) -> Color = { original ->
    // これは、色を別の色の上に重ねることができ、その結果の色を返します。
    // https://android-review.googlesource.com/c/platform/frameworks/support/+/1182625
    BlackScrim.compositeOver(original)
}
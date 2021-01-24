package net.kwmt27.jetpackcomposeplayground.utils

import android.view.View
import android.view.Window
import androidx.compose.runtime.staticAmbientOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.toArgb

interface SystemUiController {
    fun setStatusBarColor(
        color: Color,
        darkIcons: Boolean = color.luminance() > 0.5f
    )
}

fun SystemUiController(window: Window): SystemUiController {
    return SystemUiControllerImpl(window)
}

/**
 * An [androidx.compose.runtime.Ambient] holding the current [SysUiController]. Defaults to a
 * no-op controller; consumers should [provide][androidx.compose.runtime.Providers] a real one.
 */
val SysUiController = staticAmbientOf<SystemUiController> {
    FakeSystemUiController
}

private class SystemUiControllerImpl(private val window: Window) : SystemUiController {
    override fun setStatusBarColor(
        color: Color,
        darkIcons: Boolean
    ) {
        window.statusBarColor = color.toArgb()
        @Suppress("DEPRECATION")
        if (darkIcons) {
            window.decorView.systemUiVisibility = window.decorView.systemUiVisibility or
                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        } else {
            window.decorView.systemUiVisibility = window.decorView.systemUiVisibility and
                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
        }
    }
}

private object FakeSystemUiController : SystemUiController {
    override fun setStatusBarColor(color: Color, darkIcons: Boolean) = Unit
}

private val BlackScrim = Color(0f, 0f, 0f, 0.2f)
private val BlackScrimmed: (Color) -> Color = { original ->
    // これは、色を別の色の上に重ねることができ、その結果の色を返します。
    // https://android-review.googlesource.com/c/platform/frameworks/support/+/1182625
    BlackScrim.compositeOver(original)
}
package net.kwmt27.camerax.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import net.kwmt27.jetpackcomposeplayground.ui.theme.purple200
import net.kwmt27.jetpackcomposeplayground.ui.theme.purple500
import net.kwmt27.jetpackcomposeplayground.ui.theme.purple700
import net.kwmt27.jetpackcomposeplayground.ui.theme.shapes
import net.kwmt27.jetpackcomposeplayground.ui.theme.teal200
import net.kwmt27.jetpackcomposeplayground.ui.theme.typography

private val DarkColorPalette = darkColors(
    primary = purple200,
    primaryVariant = purple700,
    secondary = teal200,
    background = Color(0xff121212),
)

private val LightColorPalette = lightColors(
    primary = purple500,
    primaryVariant = purple700,
    secondary = teal200,
    background = Color.White,

    /* Other default colors to override
surface = Color.White,
onPrimary = Color.White,
onSecondary = Color.Black,
onBackground = Color.Black,
onSurface = Color.Black,
*/
)

@Composable
fun JetpackComposePlayGroundTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    val systemUiController = rememberSystemUiController()
    DisposableEffect(systemUiController, colors.background) {
        onDispose {
            systemUiController.setSystemBarsColor(
                color = colors.background // .copy(alpha = 0.95f)
            )
        }
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}

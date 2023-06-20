package net.kwmt27.jetpackcomposeplayground.animation.slide.contents

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import net.kwmt27.jetpackcomposeplayground.animation.slide.SlidePreview
import net.kwmt27.jetpackcomposeplayground.animation.slide.SlideTypography

@Composable
fun DetailsAndPoints3_2() {
    val context = LocalContext.current
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column {
            Text(
                "More performance tips for Jetpack Compose",
                style = SlideTypography.body1
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                "https://youtu.be/ahXLwg2JYpc",
                style = SlideTypography.body1,
                modifier = Modifier.clickable {
                    context.startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://youtu.be/ahXLwg2JYpc")
                        )
                    )
                }
            )
        }
    }
}

@SlidePreview
@Composable
private fun PreviewDetailsAndPoints() {
    DetailsAndPoints3_2()
}

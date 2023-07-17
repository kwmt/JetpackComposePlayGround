package net.kwmt27.jetpackcomposeplayground.slide.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.kwmt27.jetpackcomposeplayground.slide.SlideTypography

@Composable
fun SlideBase(
    title: String? = null,
    subTitle: String? = null,
    content: @Composable () -> Unit,
) {
    val (verticalArrangement, horizontalAlignment) = if (title != null) Arrangement.Top to Alignment.Start else {
        Arrangement.Center to Alignment.CenterHorizontally
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 24.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
        verticalArrangement = verticalArrangement,
        horizontalAlignment = horizontalAlignment,
    ) {
        if (title != null) {
            Text(text = title, style = SlideTypography.h2)
        }
        if (subTitle != null) {
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = subTitle, style = SlideTypography.h3, modifier = Modifier.padding(16.dp))
        }
        Box(modifier = Modifier.padding(16.dp)) {
            content()
        }
    }
}

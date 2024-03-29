package net.kwmt27.jetpackcomposeplayground.slide.contents.shibuyaapk43

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.github.kwmt.slide.components.SlideBase
import com.github.kwmt.slide.ui.theme.SlidePreview
import com.github.kwmt.slide.ui.theme.SlideTypography

@Composable
internal fun Pros4_3() {
    SlideBase(
        title = "メリット",
        subTitle = PROS4_SUB_TITLE
    ) {
        Column {
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = "インジケーターを変えてみるとか",
                style = SlideTypography.body1
            )
        }
    }
}

@Composable
fun BoxScope.PageIndicatorForShibuyaApk43(pageCount: Int, currentPageIndex: Int) {
    Row(
        Modifier
            .height(50.dp)
            .fillMaxWidth()
            .align(Alignment.BottomCenter),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pageCount) { iteration ->
            val color = if (currentPageIndex == iteration) Color.DarkGray else Color.LightGray
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(10.dp)
            )
        }
    }
}

@SlidePreview
@Composable
private fun PreviewPros() {
    Pros4_3()
}

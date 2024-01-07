package net.kwmt27.jetpackcomposeplayground.legacy.feature.list

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.kwmt27.jetpackcomposeplayground.core.ui.theme.JetpackComposePlayGroundTheme

@Composable
fun GridCustomItem() {
    val sections = (0 until 25).toList().chunked(5)
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        sections.forEachIndexed { index, items ->
            item(span = { GridItemSpan(maxLineSpan) }) {
                Text(
                    "This is section $index",
                    Modifier
                        .border(1.dp, Color.Gray)
                        .height(80.dp)
                        .wrapContentSize()
                )
            }
            items(
                items,
                // not required as it is the default
                span = { GridItemSpan(1) }
            ) {
                Text(
                    "Item $it",
                    Modifier
                        .border(1.dp, Color.Blue)
                        .height(80.dp)
                        .wrapContentSize()
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewGridCustomItem() {
    JetpackComposePlayGroundTheme {
        GridCustomItem()
    }
}

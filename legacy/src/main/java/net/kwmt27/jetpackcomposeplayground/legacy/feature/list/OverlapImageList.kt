import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import net.kwmt27.jetpackcomposeplayground.common.ui.theme.JetpackComposePlayGroundTheme

@Composable
fun OverlapImageListSample() {
    val items = listOf(Item(Color.Blue), Item(Color.Red), Item(Color.Green))
    OverlapImageList(items)
}

private val LENGTH = 100.dp
private val ROUND_CORNER = LENGTH / 2
@Composable
private fun OverlapImageList(items: List<Item>) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(-ROUND_CORNER)
    ) {
        items.forEachIndexed { index, item ->
            Box(
                modifier = Modifier
                    .width(LENGTH)
                    .height(LENGTH)
                    .clip(RoundedCornerShape(ROUND_CORNER))
                    .background(item.color)
                    .border(1.dp, Color.Gray, RoundedCornerShape(ROUND_CORNER))
                    .zIndex((items.size - index).toFloat())
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewOverlapImageListSample() {
    JetpackComposePlayGroundTheme {
        OverlapImageListSample()
    }
}

private data class Item(
    val color: Color,
)

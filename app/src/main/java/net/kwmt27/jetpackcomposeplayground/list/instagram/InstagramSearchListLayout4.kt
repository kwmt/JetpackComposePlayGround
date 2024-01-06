package net.kwmt27.jetpackcomposeplayground.list.instagram

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.kwmt27.jetpackcomposeplayground.ui.theme.JetpackComposePlayGroundTheme

private const val TAG = "InstagramSearchList"

@Composable
fun SampleInstagramSearchListLayout4() {
    InstagramSearchListLayout(GridListData.createData())
}

@Composable
private fun InstagramSearchListLayout(
    gridListData: GridListData,
) {
    val listState = rememberLazyListState()
    // OK例

    BoxWithConstraints {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(1.dp),
            state = listState,
        ) {
            itemsIndexed(gridListData.list) { index, gridRowData ->
                val moviePosition = if (index % 2 == 0) {
                    MoviePosition.RIGHT
                } else {
                    MoviePosition.LEFT
                }
                GridRowItem(
                    gridRowData = gridRowData,
                    width = maxWidth / 3,
                    moviePosition = moviePosition,
                    listState = listState,
                    index = index,
                )
            }
        }
    }
}

@Composable
private fun GridRowItem(
    gridRowData: GridRowData,
    width: Dp,
    moviePosition: MoviePosition,
    listState: LazyListState,
    index: Int,
) {
    /**
     * [item][item][ItemImage]
     * [item][item] ---
     */
    val itemImageDataList: List<List<ItemData>> = gridRowData.list.take(4).chunked(2)
    val itemMovieData = gridRowData.list.last()

    Row(
        horizontalArrangement = Arrangement.spacedBy(1.dp),
    ) {
        if (moviePosition == MoviePosition.LEFT) {
            ItemMovie(itemMovieData, width, listState, index)
        }
        GridItemImages(itemImageDataList, width)

        if (moviePosition == MoviePosition.RIGHT) {
            ItemMovie(itemMovieData, width, listState, index)
        }
    }
}

@Composable
private fun GridItemImages(
    itemImageDataList: List<List<ItemData>>,
    width: Dp,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(1.dp)
    ) {
        itemImageDataList.forEach { itemImageData ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(1.dp)
            ) {
                itemImageData.forEach { itemData ->
                    ItemImage(itemData, width)
                }
            }
        }
    }
}

@Composable
private fun ItemImage(item: ItemData, width: Dp) {

    Box(
        modifier = Modifier
            .size(width = width, height = width)
            .background(color = Color.Gray),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "${item.id} 画像",
            style = TextStyle(fontSize = 20.sp, color = Color.White)
        )
    }
}

@Composable
private fun ItemMovie(item: ItemData, width: Dp, listState: LazyListState, index: Int) {
    val isPlay by remember {
        derivedStateOf {
            val firstVisibleItemIndex = if (listState.firstVisibleItemScrollOffset == 0) {
                listState.firstVisibleItemIndex
            } else {
                listState.firstVisibleItemIndex + 1
            }
            firstVisibleItemIndex == index
        }
    }

    Log.d(TAG, "ItemMovie: id=${item.id},  isPlay=$isPlay")
    val color = if (isPlay) Color.Green else Color.Red
    Column(
        modifier = Modifier
            .size(width = width, height = width * 2 + 1.dp)
            .background(color = color),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "${item.id} 動画",
            style = TextStyle(fontSize = 20.sp, color = Color.White)
        )
        val text = if (isPlay) "Playing" else "Stop"
        Text(
            text = text,
            style = TextStyle(fontSize = 20.sp, color = Color.White)
        )
    }
}

@Preview(showBackground = true, device = "spec:width=320dp,height=640dp")
@Composable
private fun PreviewInstagramSearchList4() {
    JetpackComposePlayGroundTheme {
        SampleInstagramSearchListLayout4()
    }
}

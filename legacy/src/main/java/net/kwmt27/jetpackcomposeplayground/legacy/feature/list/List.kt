package net.kwmt27.jetpackcomposeplayground.legacy.feature.list

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.kwmt27.jetpackcomposeplayground.common.ui.theme.JetpackComposePlayGroundTheme

@Composable
fun SampleVerticalList() {
    val list = listOf("AAA", "BBB", "CCC", "DDD", "EEE", "FFF", "GGG", "HHH")
    SampleUnstableList(
        list
    )
//    VerticalGridSample()
}

@Composable
private fun SampleUnstableList(
    list: List<String>,
) {
    Log.d("SampleUnstableList", "list: $list")
    LazyColumn {
        itemsIndexed(list) { index: Int, item: String ->
            Log.d("SampleUnstableList", "index: $index, item: $item")
            ListItem(item)
        }
    }
}

@Composable
fun ListItem(text: String) {
    Column {
        Box(
            modifier = Modifier
                .height(200.dp)
                .background(Color.Blue)
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = text,
                style = TextStyle(color = Color.White)
            )
        }
        Divider(modifier = Modifier.height(8.dp))
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun PreviewSampleList() {
    JetpackComposePlayGroundTheme {
        SampleVerticalList()
    }
}

@Composable
fun SampleHorizontalList() {
    LazyRow {
        items(5) { index ->
            ListHorizontalItem(index)
        }
    }
}

@Composable
fun ListHorizontalItem(index: Int = 0) {
    Column {
        Box(
            modifier = Modifier
                .width(200.dp)
                .background(Color.Blue)
                .height(200.dp)
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "index: $index",
                style = TextStyle(color = Color.White)
            )
        }
        Divider(modifier = Modifier.height(8.dp))
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun PreviewSampleHorizontalList() {
    JetpackComposePlayGroundTheme {
        SampleHorizontalList()
    }
}

private data class Contact(val firstName: String)

private const val TAG: String = "LIST"
private val contacts =
    listOf<Contact>(
        Contact("AAA"),
        Contact("ABB"),
        Contact("Bbb"),
        Contact("Bbb2"),
        Contact("Bbb3"),
        Contact("Bbb3"),
        Contact("Bbb4"),
        Contact("Ccc"),
        Contact("Ccc2"),
        Contact("Ccc3"),
        Contact("Ccc4"),
        Contact("Ccc5"),
    )
private val grouped = contacts.groupBy { it.firstName[0] }

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StickyListSample() {
    LazyColumn {
        grouped.forEach { (initial, contactsForInitial) ->
            stickyHeader {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Gray)
                        .padding(horizontal = 8.dp),
                    text = initial.toString()
                )
            }

            items(contactsForInitial) { contact ->
                ListItem2(contact.firstName)
            }
        }
    }
}

@Composable
fun ListItem2(text: String = "") {
    Column {
        Box(
            modifier = Modifier
                .height(200.dp)
                .background(Color.Blue)
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "$text",
                style = TextStyle(color = Color.White)
            )
        }
        Divider()
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun PreviewStickyListSample() {
    JetpackComposePlayGroundTheme {
        StickyListSample()
    }
}

@Composable
fun ListWithUpdatableItem() {
    val list = listOf("AAA", "BBB", "CCC", "DDD", "EEE", "FFF", "GGG", "HHH")
    Log.d("ListWithUpdatableItem", "list: $list")
    val listState = rememberLazyListState()
//    val index : Boolean = listState.firstVisibleItemIndex > 0
//    Log.d("LIST", "ListWithUpdatableItem: listState.firstVisibleItemIndex: ${listState.firstVisibleItemIndex}")
//    listState.firstVisibleItemIndex
//
    val firstVisibleCompletelyItem: Int by remember {
        derivedStateOf {
            listState.firstVisibleCompletelyItem()
        }
    }
    Log.d(TAG, "ListWithUpdatableItem: firstVisibleCompletelyItem=$firstVisibleCompletelyItem")

    LazyColumn(
        state = listState,
    ) {
        itemsIndexed(list) { index: Int, item: String ->
            Log.d("ListWithUpdatableItem", "index: $index, item: $item")
            MyCard {
                UpdatableItem(item, index == firstVisibleCompletelyItem)
            }
        }
    }
}

@Composable
private fun MyCard(content: @Composable () -> Unit) {
    content()
}

@Composable
private fun UpdatableItem(
    text: String,
    showBadge: Boolean,
) {
    Column {
        Box(
            modifier = Modifier
                .height(200.dp)
                .background(Color.Blue)
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = text,
                style = TextStyle(color = Color.White)
            )

            if (showBadge) {
                Icon(
                    imageVector = Icons.Rounded.Person,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(32.dp)
                )
            }
        }
        Divider(modifier = Modifier.height(8.dp))
    }
}

@Preview
@Composable
private fun PreviewListWithUpdatableItem() {
    JetpackComposePlayGroundTheme {
        ListWithUpdatableItem()
    }
}

private fun LazyListState.firstVisibleCompletelyItem(): Int =
    if (firstVisibleItemScrollOffset == 0) {
        firstVisibleItemIndex
    } else {
        firstVisibleItemIndex + 1
    }

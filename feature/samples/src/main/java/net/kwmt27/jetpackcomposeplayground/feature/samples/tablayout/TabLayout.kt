@file:OptIn(ExperimentalFoundationApi::class)

package net.kwmt27.jetpackcomposeplayground.feature.samples.tablayout

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabLayoutSample(viewModel: TabLayoutViewModel = TabLayoutViewModel()) {
    val pagerState = rememberPagerState { viewModel.list.size }

    Column {
        TabLayout(
            tabs = viewModel.titles,
            pagerState = pagerState
        )
        HorizontalPager(state = pagerState) {
            TextScreen(text = viewModel.contents[pagerState.currentPage])
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun TabLayout(tabs: List<String>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        divider = {
            Spacer(modifier = Modifier.height(5.dp))
        },
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage]),
                height = 5.dp,
                color = Color.White
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        tabs.forEachIndexed { index, text ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                text = {
                    Text(text = text)
                }
            )
        }
    }
}

@Composable
private fun TextScreen(text: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = text, fontSize = 24.sp)
    }
}

class TabLayoutViewModel : ViewModel() {
    data class TabData(
        val title: String,
        val content: String,
    )

    val list = listOf(
        TabData("A", "A"),
        TabData("B", "B"),
        TabData("C", "C")
    )
    val titles = list.map { it.title }
    val contents = list.map { it.content }
}

@Preview(showBackground = true)
@Composable
fun PreviewTabLayoutSample() {
    TabLayoutSample()
}

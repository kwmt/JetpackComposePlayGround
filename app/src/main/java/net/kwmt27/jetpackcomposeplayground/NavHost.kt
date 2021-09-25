package net.kwmt27.jetpackcomposeplayground

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import net.kwmt27.jetpackcomposeplayground.Destinations.SAMPLES_CIRCLE_IMAGE
import net.kwmt27.jetpackcomposeplayground.Destinations.SAMPLES_VERTICAL_LIST
import net.kwmt27.jetpackcomposeplayground.image.CircleImageSample
import net.kwmt27.jetpackcomposeplayground.list.SampleVerticalList

object Destinations {
    private const val SAMPLES = "samples"
    private const val CIRCLE_IMAGE = "circle-image"
    private const val VERTICAL_LIST = "vertical-list"
    const val SAMPLES_CIRCLE_IMAGE = "/$SAMPLES/$CIRCLE_IMAGE"
    const val SAMPLES_VERTICAL_LIST = "/$SAMPLES/$VERTICAL_LIST"
}

@Composable
fun NavHost(navController: NavHostController) {
    androidx.navigation.compose.NavHost(navController = navController, startDestination = "main") {
        composable("main") { MainList(navController) }
        composable(SAMPLES_CIRCLE_IMAGE) { CircleImageSample() }
        composable(SAMPLES_VERTICAL_LIST) { SampleVerticalList() }
    }
}

@Composable
fun MainList(navController: NavHostController) {
    LazyColumn {
        mainListItem(label = "Circle Image") { navController.navigate(SAMPLES_CIRCLE_IMAGE) }
        mainListItem(label = "Vertical List") { navController.navigate(SAMPLES_VERTICAL_LIST) }
    }
}

@OptIn(ExperimentalMaterialApi::class)
fun LazyListScope.mainListItem(label: String, onClick: () -> Unit) {
    item {
        ListItem(
            text = {
                Text(label)
            },
            modifier = Modifier.clickable(onClick = onClick)
        )
    }
}

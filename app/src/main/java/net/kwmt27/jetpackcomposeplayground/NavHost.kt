package net.kwmt27.jetpackcomposeplayground

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import net.kwmt27.jetpackcomposeplayground.Destinations.MAIN
import net.kwmt27.jetpackcomposeplayground.Destinations.SAMPLES_ANIMATION
import net.kwmt27.jetpackcomposeplayground.Destinations.SAMPLES_BOX
import net.kwmt27.jetpackcomposeplayground.Destinations.SAMPLES_CIRCLE_IMAGE
import net.kwmt27.jetpackcomposeplayground.Destinations.SAMPLES_EXPANDABLE
import net.kwmt27.jetpackcomposeplayground.Destinations.SAMPLES_VERTICAL_LIST
import net.kwmt27.jetpackcomposeplayground.animation.AnimateAsStateDemo
import net.kwmt27.jetpackcomposeplayground.box.BoxSample
import net.kwmt27.jetpackcomposeplayground.image.CircleImageSample
import net.kwmt27.jetpackcomposeplayground.list.SampleVerticalList
import net.kwmt27.jetpackcomposeplayground.state.ExpandableCardSample

object Destinations {
    private const val SAMPLES = "samples"
    private const val CIRCLE_IMAGE = "circle-image"
    private const val VERTICAL_LIST = "vertical-list"
    private const val ANIMATION = "animation"
    private const val BOX = "box"
    private const val EXPANDABLE = "expandable"
    const val MAIN = "main"
    const val SAMPLES_CIRCLE_IMAGE = "/$SAMPLES/$CIRCLE_IMAGE"
    const val SAMPLES_VERTICAL_LIST = "/$SAMPLES/$VERTICAL_LIST"
    const val SAMPLES_ANIMATION = "/$SAMPLES/$ANIMATION"
    const val SAMPLES_BOX = "/$SAMPLES/$BOX"
    const val SAMPLES_EXPANDABLE = "/$SAMPLES/$EXPANDABLE"
}

@Composable
fun NavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = MAIN) {
        composable(MAIN) { MainList(navController) }
        composable(SAMPLES_CIRCLE_IMAGE) { CircleImageSample() }
        composable(SAMPLES_VERTICAL_LIST) { SampleVerticalList() }
        composable(SAMPLES_ANIMATION) { AnimateAsStateDemo() }
        composable(SAMPLES_BOX) { BoxSample() }
        composable(SAMPLES_EXPANDABLE) { ExpandableCardSample() }
    }
}

@Composable
fun MainList(navController: NavHostController) {
    val context = LocalContext.current
    LazyColumn {
        mainListItem(label = "Circle Image") { navController.navigate(SAMPLES_CIRCLE_IMAGE) }
        mainListItem(label = "Vertical List") { navController.navigate(SAMPLES_VERTICAL_LIST) }
        mainListItem(label = "Animation") { navController.navigate(SAMPLES_ANIMATION) }
        mainListItem(label = "Box") { navController.navigate(SAMPLES_BOX) }
        mainListItem(label = "Expandable Card") { navController.navigate(SAMPLES_EXPANDABLE) }
        mainListItem(label = "Color") {
            context.startActivity(Intent(Intent.ACTION_VIEW,
                Uri.parse("https://github.com/kwmt/JetpackComposePlayGround/blob/main/app/src/main/java/net/kwmt27/jetpackcomposeplayground/color/Color.kt")))
        }
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

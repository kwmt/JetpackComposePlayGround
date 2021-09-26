package net.kwmt27.jetpackcomposeplayground

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import net.kwmt27.camerax.CameraXScreen
import net.kwmt27.jetpackcomposeplayground.Destinations.MAIN
import net.kwmt27.jetpackcomposeplayground.Destinations.SAMPLES_ANIMATION
import net.kwmt27.jetpackcomposeplayground.Destinations.SAMPLES_BOX
import net.kwmt27.jetpackcomposeplayground.Destinations.SAMPLES_CAMERAX
import net.kwmt27.jetpackcomposeplayground.Destinations.SAMPLES_CIRCLE_IMAGE
import net.kwmt27.jetpackcomposeplayground.Destinations.SAMPLES_EXPANDABLE
import net.kwmt27.jetpackcomposeplayground.Destinations.SAMPLES_HORIZONTAL_LIST
import net.kwmt27.jetpackcomposeplayground.Destinations.SAMPLES_STICKY_LIST
import net.kwmt27.jetpackcomposeplayground.Destinations.SAMPLES_UP_ICON
import net.kwmt27.jetpackcomposeplayground.Destinations.SAMPLES_VERTICAL_LIST
import net.kwmt27.jetpackcomposeplayground.animation.AnimateAsStateDemo
import net.kwmt27.jetpackcomposeplayground.box.BoxSample
import net.kwmt27.jetpackcomposeplayground.icon.UpIconSample
import net.kwmt27.jetpackcomposeplayground.image.CircleImageSample
import net.kwmt27.jetpackcomposeplayground.list.SampleHorizontalList
import net.kwmt27.jetpackcomposeplayground.list.SampleVerticalList
import net.kwmt27.jetpackcomposeplayground.list.StickyListSample
import net.kwmt27.jetpackcomposeplayground.state.ExpandableCardSample

object Destinations {
    private const val SAMPLES = "samples"
    private const val CIRCLE_IMAGE = "circle-image"
    private const val VERTICAL_LIST = "vertical-list"
    private const val HORIZONTAL_LIST = "horizontal-list"
    private const val STICKY_LIST = "sticky-list"
    private const val ANIMATION = "animation"
    private const val BOX = "box"
    private const val EXPANDABLE = "expandable"
    private const val UP_ICON = "up_icon"
    private const val CAMERAX = "camerax"
    const val MAIN = "main"
    const val SAMPLES_CIRCLE_IMAGE = "/$SAMPLES/$CIRCLE_IMAGE"
    const val SAMPLES_VERTICAL_LIST = "/$SAMPLES/$VERTICAL_LIST"
    const val SAMPLES_HORIZONTAL_LIST = "/$SAMPLES/$HORIZONTAL_LIST"
    const val SAMPLES_STICKY_LIST = "/$SAMPLES/$STICKY_LIST"
    const val SAMPLES_ANIMATION = "/$SAMPLES/$ANIMATION"
    const val SAMPLES_BOX = "/$SAMPLES/$BOX"
    const val SAMPLES_EXPANDABLE = "/$SAMPLES/$EXPANDABLE"
    const val SAMPLES_UP_ICON = "/$SAMPLES/$UP_ICON"
    const val SAMPLES_CAMERAX = "/$SAMPLES/$CAMERAX"
}

@Composable
fun NavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = MAIN) {
        composable(MAIN) { MainList(navController) }
        composable(SAMPLES_CIRCLE_IMAGE) { CircleImageSample() }
        composable(SAMPLES_VERTICAL_LIST) { SampleVerticalList() }
        composable(SAMPLES_HORIZONTAL_LIST) { SampleHorizontalList() }
        composable(SAMPLES_STICKY_LIST) { StickyListSample() }
        composable(SAMPLES_ANIMATION) { AnimateAsStateDemo() }
        composable(SAMPLES_BOX) { BoxSample() }
        composable(SAMPLES_EXPANDABLE) { ExpandableCardSample() }
        composable(SAMPLES_UP_ICON) { UpIconSample() }
        composable(SAMPLES_CAMERAX) { CameraXScreen() }
    }
}

@Composable
fun MainList(navController: NavHostController) {
    val context = LocalContext.current
    LazyColumn {
        header("Image")
        mainListItem(label = "Circle Image") { navController.navigate(SAMPLES_CIRCLE_IMAGE) }
        header("List")
        mainListItem(label = "Vertical List") { navController.navigate(SAMPLES_VERTICAL_LIST) }
        mainListItem(label = "Horizontal List") { navController.navigate(SAMPLES_HORIZONTAL_LIST) }
        mainListItem(label = "Sticky Header List") { navController.navigate(SAMPLES_STICKY_LIST) }
        header("Animation")
        mainListItem(label = "Change Color") { navController.navigate(SAMPLES_ANIMATION) }
        mainListItem(label = "Expandable Card") { navController.navigate(SAMPLES_EXPANDABLE) }
        header("Box")
        mainListItem(label = "Box") { navController.navigate(SAMPLES_BOX) }
        header("Icon")
        mainListItem(label = "Up Icon") { navController.navigate(SAMPLES_UP_ICON) }

        header("Color")
        mainListItem(label = "Color") {
            context.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://github.com/kwmt/JetpackComposePlayGround/blob/main/app/src/main/java/net/kwmt27/jetpackcomposeplayground/color/Color.kt")
                )
            )
        }
        header("CameraX")
        mainListItem(label = "CameraX") { navController.navigate(SAMPLES_CAMERAX) }
    }
}

@OptIn(ExperimentalFoundationApi::class)
fun LazyListScope.header(title: String) {
    stickyHeader {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray)
                .padding(horizontal = 8.dp),
            text = title
        )
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

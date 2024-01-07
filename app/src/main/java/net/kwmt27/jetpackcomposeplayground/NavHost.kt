package net.kwmt27.jetpackcomposeplayground

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.ListItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import net.kwmt27.camerax.CameraXScreen
import net.kwmt27.jetpackcomposeplayground.Destinations.INSTAGRAM_SEARCH_LIST
import net.kwmt27.jetpackcomposeplayground.Destinations.LAYOUT_TAB
import net.kwmt27.jetpackcomposeplayground.Destinations.MAIN
import net.kwmt27.jetpackcomposeplayground.Destinations.SAMPLES_ANIMATION_AUTO_ROLLING_TEXT
import net.kwmt27.jetpackcomposeplayground.Destinations.SAMPLES_ANIMATION_CHANGE_COLOR
import net.kwmt27.jetpackcomposeplayground.Destinations.SAMPLES_ANIMATION_TRANSITION
import net.kwmt27.jetpackcomposeplayground.Destinations.SAMPLES_BOX
import net.kwmt27.jetpackcomposeplayground.Destinations.SAMPLES_BUTTON
import net.kwmt27.jetpackcomposeplayground.Destinations.SAMPLES_CAMERAX
import net.kwmt27.jetpackcomposeplayground.Destinations.SAMPLES_CIRCLE_IMAGE
import net.kwmt27.jetpackcomposeplayground.Destinations.SAMPLES_COROUTINE
import net.kwmt27.jetpackcomposeplayground.Destinations.SAMPLES_EXPANDABLE
import net.kwmt27.jetpackcomposeplayground.Destinations.SAMPLES_HORIZONTAL_LIST
import net.kwmt27.jetpackcomposeplayground.Destinations.SAMPLES_LIVEDATA
import net.kwmt27.jetpackcomposeplayground.Destinations.SAMPLES_STICKY_LIST
import net.kwmt27.jetpackcomposeplayground.Destinations.SAMPLES_UP_ICON
import net.kwmt27.jetpackcomposeplayground.Destinations.SAMPLES_VERTICAL_LIST
import net.kwmt27.jetpackcomposeplayground.Destinations.SLIDE_POTATOTIPS82
import net.kwmt27.jetpackcomposeplayground.Destinations.SLIDE_SHIBUYAAPK43
import net.kwmt27.jetpackcomposeplayground.Destinations.UPDATABLE_ITEM_LIST
import net.kwmt27.jetpackcomposeplayground.animation.AnimateAsStateDemo
import net.kwmt27.jetpackcomposeplayground.animation.AnimatedContentSizeDemo
import net.kwmt27.jetpackcomposeplayground.animation.AnimatedVisibilityDemo
import net.kwmt27.jetpackcomposeplayground.animation.AutoRollingTextSample
import net.kwmt27.jetpackcomposeplayground.animation.CrossFadeDemo
import net.kwmt27.jetpackcomposeplayground.animation.UpdateTransitionDemo
import net.kwmt27.jetpackcomposeplayground.legacy.feature.bottomsheet.BottomSheetLongDataSample
import net.kwmt27.jetpackcomposeplayground.legacy.feature.bottomsheet.BottomSheetSample
import net.kwmt27.jetpackcomposeplayground.legacy.feature.box.BoxSample
import net.kwmt27.jetpackcomposeplayground.button.ButtonSample
import net.kwmt27.jetpackcomposeplayground.coroutine.CancellationExceptionSample
import net.kwmt27.jetpackcomposeplayground.edittext.OutlinedTextFieldSample
import net.kwmt27.jetpackcomposeplayground.icon.UpIconSample
import net.kwmt27.jetpackcomposeplayground.image.CircleImageSample
import net.kwmt27.jetpackcomposeplayground.list.ListWithUpdatableItem
import net.kwmt27.jetpackcomposeplayground.list.SampleHorizontalList
import net.kwmt27.jetpackcomposeplayground.list.SampleVerticalList
import net.kwmt27.jetpackcomposeplayground.list.StickyListSample
import net.kwmt27.jetpackcomposeplayground.list.instagram.SampleInstagramSearchListLayout
import net.kwmt27.jetpackcomposeplayground.livedata.SampleMutableLiveDataScreen
import net.kwmt27.jetpackcomposeplayground.slide.SlideApp
import net.kwmt27.jetpackcomposeplayground.slide.contents.potatotips82.PotatoTips82
import net.kwmt27.jetpackcomposeplayground.slide.contents.shibuyaapk43.ShibuyaApk43Presentation
import net.kwmt27.jetpackcomposeplayground.state.ExpandableCardSample
import net.kwmt27.jetpackcomposeplayground.tablayout.TabLayoutSample

private data class Group(
    val groupLabel: String,
    val destinations: List<Destination>,
)

private data class Destination(
    val route: String,
    val label: String,
    val content: @Composable () -> Unit,
    val codeUrl: String,
)

private object Destinations {
    private const val SAMPLES = "samples"
    private const val CIRCLE_IMAGE = "circle-image"
    private const val VERTICAL_LIST = "vertical-list"
    private const val HORIZONTAL_LIST = "horizontal-list"
    private const val STICKY_LIST = "sticky-list"
    private const val UPDATABLE_LIST = "ListWithUpdatableItem"
    private const val INSTAGRAM_SEARCH_LIST_LAYOUT = "InstagramSearchListLayout"
    private const val ANIMATION = "animation"
    private const val ANIMATION_TRANSITION = "animation-transition"
    private const val ANIMATION_AUTO_ROLLING_TEXT = "animation-auto-rolling-text"
    private const val BOX = "box"
    private const val COROUTINE = "coroutine"
    private const val EXPANDABLE = "expandable"
    private const val UP_ICON = "up_icon"
    private const val CAMERAX = "camerax"
    const val SLIDE = "slide"
    private const val BUTTON = "button"
    private const val LIVEDATA = "livedata"
    const val MAIN = "main"
    const val SAMPLES_CIRCLE_IMAGE = "/$SAMPLES/$CIRCLE_IMAGE"
    const val SAMPLES_VERTICAL_LIST = "/$SAMPLES/$VERTICAL_LIST"
    const val SAMPLES_HORIZONTAL_LIST = "/$SAMPLES/$HORIZONTAL_LIST"
    const val SAMPLES_STICKY_LIST = "/$SAMPLES/$STICKY_LIST"
    const val UPDATABLE_ITEM_LIST = "/$SAMPLES/$UPDATABLE_LIST"
    const val INSTAGRAM_SEARCH_LIST = "/$SAMPLES/$INSTAGRAM_SEARCH_LIST_LAYOUT"
    const val SAMPLES_ANIMATION_CHANGE_COLOR = "/$SAMPLES/$ANIMATION"
    const val SAMPLES_ANIMATION_TRANSITION = "/$SAMPLES/$ANIMATION_TRANSITION"
    const val SAMPLES_ANIMATION_AUTO_ROLLING_TEXT = "/$SAMPLES/$ANIMATION_AUTO_ROLLING_TEXT"
    const val SAMPLES_BOX = "/$SAMPLES/$BOX"
    const val SAMPLES_COROUTINE = "/$SAMPLES/$COROUTINE"
    const val SAMPLES_EXPANDABLE = "/$SAMPLES/$EXPANDABLE"
    const val SAMPLES_UP_ICON = "/$SAMPLES/$UP_ICON"
    const val SAMPLES_CAMERAX = "/$SAMPLES/$CAMERAX"
    const val SAMPLES_BUTTON = "/$SAMPLES/$BUTTON"
    const val SAMPLES_LIVEDATA = "/$SAMPLES/$LIVEDATA"
    const val SLIDE_POTATOTIPS82 = "/$SLIDE/SLIDE_POTATOTIPS82"
    const val SLIDE_SHIBUYAAPK43 = "/$SLIDE/SLIDE_SHIBUYAAPK43"
    const val LAYOUT_TAB = "/Layout/tab_layout"
}

private val destinationList = listOf(
    Group(
        groupLabel = "Layout",
        destinations = listOf(
            Destination(
                "BottomSheet",
                "Bottom Sheet",
                { BottomSheetSample() },
                "https://github.com/kwmt/JetpackComposePlayGround/blob/main/app/src/main/java/net/kwmt27/jetpackcomposeplayground/bottomsheet/BottomSheet.kt#L29"
            ),
            Destination(
                "BottomSheetLongDataSample",
                "BottomSheetLongDataSample",
                { BottomSheetLongDataSample() },
                "https://github.com/kwmt/JetpackComposePlayGround/blob/main/app/src/main/java/net/kwmt27/jetpackcomposeplayground/bottomsheet/BottomSheet.kt.kt#L62-L104"
            ),
            Destination(
                LAYOUT_TAB,
                "Tab Layout",
                { TabLayoutSample() },
                ""
            ),
        )
    ),
    Group(
        groupLabel = "Button",
        destinations = listOf(
            Destination(
                SAMPLES_BUTTON,
                "Button",
                { ButtonSample() },
                "https://github.com/kwmt/JetpackComposePlayGround/blob/main/app/src/main/java/net/kwmt27/jetpackcomposeplayground/bottomsheet/BottomSheet.kt.kt#L27-L60"
            ),
        )
    ),
    Group(
        groupLabel = "Image",
        destinations = listOf(
            Destination(
                SAMPLES_CIRCLE_IMAGE,
                "Circle Image",
                { CircleImageSample() },
                "https://github.com/kwmt/JetpackComposePlayGround/blob/main/app/src/main/java/net/kwmt27/jetpackcomposeplayground/image/Image.kt#L27-L40"
            ),
        )
    ),
    Group(
        groupLabel = "List",
        destinations = listOf(
            Destination(
                route = SAMPLES_VERTICAL_LIST,
                label = "Vertical List",
                content = { SampleVerticalList() },
                codeUrl = "https://github.com/kwmt/JetpackComposePlayGround/blob/main/app/src/main/java/net/kwmt27/jetpackcomposeplayground/list/List.kt#L25-L51"
            ),
            Destination(
                route = SAMPLES_HORIZONTAL_LIST,
                label = "Horizontal List",
                content = { SampleHorizontalList() },
                codeUrl = "https://github.com/kwmt/JetpackComposePlayGround/blob/main/app/src/main/java/net/kwmt27/jetpackcomposeplayground/list/List.kt#L61-L87"
            ),
            Destination(
                route = SAMPLES_STICKY_LIST,
                label = "Sticky List",
                content = { StickyListSample() },
                codeUrl = "https://github.com/kwmt/JetpackComposePlayGround/blob/main/app/src/main/java/net/kwmt27/jetpackcomposeplayground/list/List.kt#L116-L155"
            ),
            Destination(
                route = UPDATABLE_ITEM_LIST,
                label = "ListWithUpdatableItem",
                content = { ListWithUpdatableItem() },
                codeUrl = ""
            ),
            Destination(
                route = INSTAGRAM_SEARCH_LIST,
                label = "InstagramSearchListLayout",
                content = { SampleInstagramSearchListLayout() },
                codeUrl = ""
            ),
        )
    ),
    Group(
        "Animation",
        listOf(
            Destination(
                SAMPLES_ANIMATION_CHANGE_COLOR,
                "Change Color",
                { AnimateAsStateDemo() },
                "https://github.com/kwmt/JetpackComposePlayGround/blob/main/app/src/main/java/net/kwmt27/jetpackcomposeplayground/animation/animation.kt#L40-L57"
            ),
            Destination(
                SAMPLES_ANIMATION_TRANSITION,
                "Change Color and Size",
                { UpdateTransitionDemo() },
                "https://github.com/kwmt/JetpackComposePlayGround/blob/main/app/src/main/java/net/kwmt27/jetpackcomposeplayground/animation/animation.kt#L70-L112"
            ),
            Destination(
                "Visibility",
                "Visibility",
                { AnimatedVisibilityDemo() },
                "https://github.com/kwmt/JetpackComposePlayGround/blob/main/app/src/main/java/net/kwmt27/jetpackcomposeplayground/animation/animation.kt#L120-L140"
            ),
            Destination(
                "ChangeContentSize",
                "Change Content Size",
                { AnimatedContentSizeDemo() },
                "https://github.com/kwmt/JetpackComposePlayGround/blob/main/app/src/main/java/net/kwmt27/jetpackcomposeplayground/animation/animation.kt#L148-L174"
            ),
            Destination(
                "CrossFade",
                "Cross Fade",
                { CrossFadeDemo() },
                "https://github.com/kwmt/JetpackComposePlayGround/blob/main/app/src/main/java/net/kwmt27/jetpackcomposeplayground/animation/animation.kt#L187-L218"
            ),
            Destination(
                SAMPLES_EXPANDABLE,
                "Expandable Card",
                { ExpandableCardSample() },
                "https://github.com/kwmt/JetpackComposePlayGround/blob/main/app/src/main/java/net/kwmt27/jetpackcomposeplayground/state/ExpandableCard.kt#L24-L56"
            ),
            Destination(
                SAMPLES_ANIMATION_AUTO_ROLLING_TEXT,
                "Auto Rolling Text",
                { AutoRollingTextSample() },
                "https://github.com/kwmt/JetpackComposePlayGround/blob/main/app/src/main/java/net/kwmt27/jetpackcomposeplayground/state/ExpandableCard.kt#L24-L56"
            ),
        )
    ),
    Group(
        "Box",
        listOf(
            Destination(
                SAMPLES_BOX,
                "Box",
                { BoxSample() },
                "https://github.com/kwmt/JetpackComposePlayGround/blob/main/app/src/main/java/net/kwmt27/jetpackcomposeplayground/box/Box.kt#L18-L48"
            ),
        )
    ),
    Group(
        "coroutine",
        listOf(
            Destination(
                SAMPLES_COROUTINE,
                "CancellationExceptionSample",
                { CancellationExceptionSample() },
                ""
            ),
        )
    ),
    Group(
        "TextField",
        listOf(
            Destination(
                "OutlinedTextFieldSample",
                "Outlined TextField",
                { OutlinedTextFieldSample() },
                "https://github.com/kwmt/JetpackComposePlayGround/blob/main/app/src/main/java/net/kwmt27/jetpackcomposeplayground/box/Box.kt#L18-L48"
            ),
        )
    ),
    Group(
        "Icon",
        listOf(
            Destination(
                SAMPLES_UP_ICON,
                "Up Icon",
                { UpIconSample() },
                "https://github.com/kwmt/JetpackComposePlayGround/blob/main/app/src/main/java/net/kwmt27/jetpackcomposeplayground/icon/Icon.kt#L22-L41"
            ),
        )
    ),
    Group(
        "camerax",
        listOf(
            Destination(
                SAMPLES_CAMERAX,
                "CameraX",
                { CameraXScreen() },
                "https://github.com/kwmt/JetpackComposePlayGround/blob/main/camerax/src/main/java/net/kwmt27/camerax/CameraXActivity.kt#L27-L45"
            ),
        )
    ),
    Group(
        "livedata",
        listOf(
            Destination(
                SAMPLES_LIVEDATA,
                "MutableLivedata",
                { SampleMutableLiveDataScreen() },
                ""
            ),
        ),
    )
)
private val slideDestination = listOf(
    Group(
        groupLabel = "slide",
        destinations = listOf(
            Destination(
                route = SLIDE_POTATOTIPS82,
                label = "potatotips #82",
                content = { PotatoTips82.SlideApp() },
                codeUrl = ""
            ),
            Destination(
                route = SLIDE_SHIBUYAAPK43,
                label = "Shibuya.apk #43",
                content = { ShibuyaApk43Presentation.SlideApp() },
                codeUrl = "https://github.com/kwmt/JetpackComposePlayGround/blob/main/app/src/main/java/net/kwmt27/jetpackcomposeplayground/bottomsheet/BottomSheet.kt#L29"
            )
        )
    ),
)

@Composable
fun NavHost(navController: NavHostController) {
    val context = LocalContext.current
    NavHost(navController = navController, startDestination = MAIN) {
        composable(MAIN) { MainList(navController) }

        destinationList.flatMap { it.destinations }.forEach { destination ->
            composable(route = destination.route) {
                FabLayout(
                    onClick = {
                        context.startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse(destination.codeUrl)
                            )
                        )
                    }
                ) {
                    destination.content()
                }
            }
        }
        slideDestination.flatMap { it.destinations }.forEach { destination ->
            composable(route = destination.route) {
                destination.content()
            }
        }
    }
}

@Composable
private fun MainList(navController: NavHostController) {
    LazyColumn {
        (slideDestination + destinationList).forEach { group ->
            header(group.groupLabel)

            group.destinations.forEach { destination ->
                mainListItem(label = destination.label) { navController.navigate(destination.route) }
            }
        }
    }
}

@Composable
private fun FabLayout(onClick: () -> Unit, content: @Composable (PaddingValues) -> Unit) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onClick) {
                Icon(
                    imageVector = Icons.Rounded.Info,
                    contentDescription = null,
                )
            }
        },
        content = content
    )
}

@OptIn(ExperimentalFoundationApi::class)
private fun LazyListScope.header(title: String) {
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
private fun LazyListScope.mainListItem(label: String, onClick: () -> Unit) {
    item {
        ListItem(
            text = {
                Text(label)
            },
            modifier = Modifier.clickable(onClick = onClick)
        )
    }
}

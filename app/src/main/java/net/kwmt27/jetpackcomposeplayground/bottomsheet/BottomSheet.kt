package net.kwmt27.jetpackcomposeplayground.bottomsheet

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ListItem
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetSample() {
    val modalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    )
    ModalBottomSheetLayout(
        sheetState = modalBottomSheetState,
        sheetShape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp),
        sheetContent = {
            LazyColumn() {
                items(5) {
                    ListItem(
                        text = {
                            Text(
                                color = Color(0xFF000000),
                                text = "Item $it"
                            )
                        },
                        icon = {
                            Icon(
                                Icons.Default.Favorite,
                                contentDescription = "Localized description",
                                tint = Color(0xFFFFFFFF),
                            )
                        }
                    )
                }
            }
        }
    ) {
        MainScreen(modalBottomSheetState)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetLongDataSample() {
    var cornerSize by remember { mutableStateOf(10.dp) }
    val modalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = {
            cornerSize = when (it) {
                ModalBottomSheetValue.Hidden -> 10.dp
                ModalBottomSheetValue.Expanded -> 0.dp
                ModalBottomSheetValue.HalfExpanded -> 10.dp
            }
            true
        },
    )
    ModalBottomSheetLayout(
        sheetState = modalBottomSheetState,
        sheetShape = RoundedCornerShape(topStart = cornerSize, topEnd = cornerSize),
        sheetContent = {
            LazyColumn() {
                items(25) {
                    ListItem(
                        text = {
                            Text(
                                color = Color(0xFF000000),
                                text = "Item $it"
                            )
                        },
                        icon = {
                            Icon(
                                Icons.Default.Favorite,
                                contentDescription = "Localized description",
                                tint = Color(0xFFFFFFFF),
                            )
                        }
                    )
                }
            }
        }
    ) {
        MainScreen(modalBottomSheetState)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreen(modalBottomSheetState: ModalBottomSheetState) {
    val coroutineScope = rememberCoroutineScope()
    Scaffold() {
        Button(onClick = {
            coroutineScope.launch {
                modalBottomSheetState.show()
            }
        }) {
            Text("show bottom sheet")
        }
    }
}
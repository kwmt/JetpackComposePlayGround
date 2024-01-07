package net.kwmt27.camerax

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import net.kwmt27.jetpackcomposeplayground.common.ui.theme.JetpackComposePlayGroundTheme

class CameraXActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePlayGroundTheme {
                // A surface container using the 'background' color from the theme
                CameraXScreen()
            }
        }
    }
}

@Composable
fun CameraXScreen() {
    var onSettingBack by remember { mutableStateOf(false) }
    var isGranted by remember { mutableStateOf(false) }
    Surface(color = MaterialTheme.colors.background) {
        PermissionHandler { granted ->
            isGranted = granted
        }

        if (isGranted || onSettingBack) {
            onSettingBack = false
            CameraPreviewSampleScreen()
        } else {
            PermissionNotGrantedView {
                onSettingBack = true
            }
        }
    }
}

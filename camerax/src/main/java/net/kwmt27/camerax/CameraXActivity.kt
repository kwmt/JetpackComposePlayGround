package net.kwmt27.camerax

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import net.kwmt27.camerax.ui.theme.JetpackComposePlayGroundTheme
import net.kwmt27.jetpackcomposeplayground.camerax.CameraPreviewSampleScreen

class CameraXActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val handler = PermissionHandler(this)
        setContent {
            JetpackComposePlayGroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val onGranted by handler.onGranted.collectAsState()
                    val context = LocalContext.current
                    if (onGranted) {
                        CameraPreviewSampleScreen()
                    } else {
                        PermissionNotGrantedView {
                            handler.request(context = context)
                        }
                        handler.request(context = context)
                    }
                }
            }
        }
    }
}


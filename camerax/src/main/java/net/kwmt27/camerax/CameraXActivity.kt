package net.kwmt27.camerax

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import net.kwmt27.camerax.ui.theme.JetpackComposePlayGroundTheme
import net.kwmt27.jetpackcomposeplayground.camerax.CameraPreviewSampleScreen

class CameraXActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePlayGroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    CameraPreviewSampleScreen()
                }
            }
        }
    }
}


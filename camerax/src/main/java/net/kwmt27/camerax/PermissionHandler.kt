package net.kwmt27.camerax

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts.RequestPermission
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat

@Composable
fun PermissionHandler(onGranted: (Boolean) -> Unit) {
    val launcher = rememberLauncherForActivityResult(RequestPermission()) { granted ->
        onGranted(granted)
    }
    val context = LocalContext.current
    if (ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED
    ) {
        // Some works that require permission
        onGranted(true)
    } else {
        // https://stackoverflow.com/a/68331596/2520998
        SideEffect {
            // Asking for permission
            launcher.launch(Manifest.permission.CAMERA)
        }
    }
}

package net.kwmt27.camerax

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts.RequestPermission
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PermissionHandler(activity: ComponentActivity) {
    private val _onGranted = MutableStateFlow(false)
    val onGranted: StateFlow<Boolean> = _onGranted
    private var permissionLauncher: ActivityResultLauncher<String>? = null

    init {
        // startedになるまえにregisterForActivityResultを呼ばないといけない。
        // Fragmentをタブで切り替えるとき、初回はActivityにStateはCREATEDだが、再描画されたらActivityのStateはRESUMEになっているため
        // チェックしておく必要がある。
        // https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main:activity/activity/src/main/java/androidx/activity/result/ActivityResultRegistry.java;l=120?q=ActivityResultRegistry
        if (!activity.lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
            permissionLauncher =
                activity.registerForActivityResult(RequestPermission()) { isGranted ->
                    if (isGranted) {
                        _onGranted.value = true
                    } else {
                    }
                }
        }
    }

    fun request(context: Context) {
        if (ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            // Some works that require permission
            _onGranted.value = true
        } else {
            // Asking for permission
            permissionLauncher?.launch(Manifest.permission.CAMERA)
        }
    }

    fun dispose() {
        permissionLauncher?.unregister()
    }
}

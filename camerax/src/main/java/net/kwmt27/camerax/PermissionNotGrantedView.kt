package net.kwmt27.camerax

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PermissionNotGrantedView(callback: () -> Unit) {
    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            callback()
        }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val context = LocalContext.current

        Column(modifier = Modifier.align(Alignment.Center)) {
            Text(
                stringResource(
                    R.string.to_continue_give_app_access_to,
                    stringResource(R.string.app_name),
                    stringResource(R.string.permission_camera)
                ),
//                color = DevChallengeTheme.colors.textBody1,
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 24.dp, end = 24.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))
            Button(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                onClick = { gotoSettingApp(context, launcher) },
                colors = ButtonDefaults.buttonColors(
//                    backgroundColor = DevChallengeTheme.colors.secondary,
//                    contentColor = DevChallengeTheme.colors.textButton1
                ),
            ) {
                Text(
                    stringResource(R.string.go_to_settings),
                    fontSize = 20.sp,
                )
            }
        }
    }
}

private fun gotoSettingApp(
    context: Context,
    launcher: ManagedActivityResultLauncher<Intent, ActivityResult>,
) {
    val data = Uri.fromParts("package", context.packageName, null)
    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        .setData(data)
    launcher.launch(intent)
}

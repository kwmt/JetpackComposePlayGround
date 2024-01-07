package net.kwmt27.jetpackcomposeplayground.legacy.feature.button

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ButtonSample() {
    Column() {
        MyButton(text = "編集ボタン") {
        }
//        Spacer(modifier = Modifier.padding(top = 8.dp))
        BoxWithConstraints {
            Log.d("ButtonLayout", "ButtonLayout: $maxWidth ")
            if (maxWidth <= 320.dp) {
                LargeLayout()
            } else {
                LargeLayout()
            }
        }
    }
}

@Composable
private fun LargeLayout() {
    Row() {
        MyButton(text = "編集ボタン") {
        }

        Spacer(modifier = Modifier.padding(start = 8.dp))
        MyButton(text = "編集ボタン") {
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun MyButton(
    text: String,
    onClick: () -> Unit,
) {
    /**
     * https://stackoverflow.com/a/72870364/2520998
     * https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary#LocalMinimumInteractiveComponentEnforcement()
     * アクセシビリティの観点からPaddingが着くようになっているが、LocalMinimumInteractiveComponentEnforcement をfalseにすればPaddingを消すことができる。
     */
    CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides false) {
        Button(
            modifier = Modifier
                .defaultMinSize(40.dp)
                .padding(0.dp)
                .background(Color.Cyan),
            border = BorderStroke(1.dp, Color.Gray),
            elevation = null,
            onClick = onClick,
        ) {
            Text(
                text = text,
            )
        }
    }
}

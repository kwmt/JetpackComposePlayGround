package net.kwmt27.jetpackcomposeplayground.livedata

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun SampleMutableLiveDataScreen() {
    val context = LocalContext.current
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clickable {
                    context.startActivity(MutableLiveDataSampleActivity.createIntent(context))
                },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            SampleMutableLiveDataItem(
                title = "MutableLiveData",
            )
        }
    }
}

@Composable
fun SampleMutableLiveDataItem(title: String) {
    Text(text = title)
}
//@Composable
//private fun SampleMutableLiveDataScreen() {
//
//}

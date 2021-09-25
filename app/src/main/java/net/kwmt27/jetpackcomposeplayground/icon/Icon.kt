package net.kwmt27.jetpackcomposeplayground.icon

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun UpIconSample() {
    Up {}
}
@Composable
fun Up(
    upPress: () -> Unit,
) {
    IconButton(
        onClick = upPress,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .size(36.dp)
            .background(
                color = Color.White.copy(alpha = 0.32f),
                shape = CircleShape
            )
    ) {
        Icon(
            imageVector = Icons.Rounded.ArrowBack,
            contentDescription = "back"
        )
    }
}

val Shadow4 = Color(0xff7057f5)

@Preview
@Composable
fun PreviewUp() {
    Box(modifier = Modifier.background(Shadow4)) {
        Up {}
    }
}

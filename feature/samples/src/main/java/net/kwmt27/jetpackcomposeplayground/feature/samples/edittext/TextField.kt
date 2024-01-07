package net.kwmt27.jetpackcomposeplayground.feature.samples.edittext

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ContentAlpha
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun OutlinedTextFieldSample(viewModel: OutlinedTextFieldSampleViewModel = OutlinedTextFieldSampleViewModel()) {
    val query by viewModel.query.collectAsState()

    OutlinedTextField(
        modifier = Modifier
            .padding(8.dp)
            .height(56.dp)
            .fillMaxWidth(),
        value = query,
        onValueChange = { newValue ->
            viewModel.onQueryChanged(newValue)
        },
        placeholder = { Text("Hint") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            cursorColor = Color.Black,
            focusedBorderColor = Color.Black.copy(alpha = ContentAlpha.high),
            unfocusedBorderColor = Color.Black
        ),
        singleLine = true,
    )
}

class OutlinedTextFieldSampleViewModel : ViewModel() {
    private val _query = MutableStateFlow("")
    val query: StateFlow<String> = _query
    fun onQueryChanged(query: String) {
        _query.value = query
    }
}

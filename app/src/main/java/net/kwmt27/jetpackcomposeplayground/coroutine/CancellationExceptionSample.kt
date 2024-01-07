package net.kwmt27.jetpackcomposeplayground.coroutine

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import net.kwmt27.jetpackcomposeplayground.common.ui.theme.JetpackComposePlayGroundTheme
import net.kwmt27.jetpackcomposeplayground.coroutine.CancellationExceptionSampleViewModel.State

@Composable
fun CancellationExceptionSample(
    viewModel: CancellationExceptionSampleViewModel = remember { CancellationExceptionSampleViewModel() },
) {
    Log.d("TAG", "CancellationExceptionSample: viewModel = $viewModel")
    val state by viewModel.state.collectAsState()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            CancellationExceptionSampleSuccess(
                text = (state as? State.Success)?.text ?: "initial",
                onButtonClick = {
                    viewModel.updateText()
                },
                onCancelButtonClick = {
                    viewModel.cancel()
                }
            )
            if (state is State.Error) {
                val error = state as State.Error
                Text(text = error.e.toString())
            }
        }

        if (state == State.Loading) {
            CircularProgressIndicator()
        }
    }
}

@Composable
private fun CancellationExceptionSampleSuccess(
    text: String,
    onButtonClick: () -> Unit,
    onCancelButtonClick: () -> Unit,
) {
    Box {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = text)

            Row {
                Button(onClick = onButtonClick) {
                    Text("ボタン")
                }

                Spacer(modifier = Modifier.padding(16.dp))

                Button(onClick = onCancelButtonClick) {
                    Text("キャンセル")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCancellationExceptionSample() {
    JetpackComposePlayGroundTheme {
        CancellationExceptionSample()
    }
}

class CancellationExceptionSampleViewModel : ViewModel() {
    sealed interface State {
        object Init : State
        object Loading : State
        data class Success(
            val text: String = "",
        ) : State

        data class Error(val e: Exception) : State
    }

    private val _state: MutableStateFlow<State> = MutableStateFlow(State.Init)
    val state: StateFlow<State> = _state

    init {
        viewModelScope.launch {
            state.collect {
                try {
                    Log.d("TAG", "state.collect $it")
                    suspendCoroutine(it)
                } catch (e: CancellationException) {
                    Log.d("TAG", "state.collect $e")
                    throw e
                } catch (e: Exception) {
                    Log.d("TAG", "collect: $e")
                }
            }
        }
    }

    private suspend fun suspendCoroutine(it: State) {
        try {
            Log.d("TAG", "suspendCoroutine $it")
            delay(3000)
            Log.d("TAG", "suspendCoroutine 3秒経過")
        } catch (e: CancellationException) {
            Log.d("TAG", "suspendCoroutine catch CancellationException $e")
            throw e
        } catch (e: Exception) {
            Log.e("TAG", "suspendCoroutine catch $it", e)
        }
    }

    var job: Job? = null
    fun updateText() {
        job = viewModelScope.launch {
            _state.value = State.Loading
            try {
                delay(10000)
                _state.value = State.Success(text = "updated")
            } catch (e: CancellationException) {
                Log.d("TAG", "updateText: $e")
                throw e
            } catch (e: Exception) {
                Log.d("TAG", "updateText: $e")
                _state.value = State.Error(e)
            }
        }
    }

    fun cancel() {
        job?.cancel()
    }
}

package net.kwmt27.jetpackcomposeplayground.camerax

import android.view.ViewGroup
import androidx.camera.core.AspectRatio
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.min
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import com.google.common.util.concurrent.ListenableFuture
import net.kwmt27.camerax.SampleImageAnalyzer
import java.util.concurrent.Executor
import kotlin.math.abs

@Composable
fun CameraPreviewSampleScreen() {
    Box {
        CameraPreview(
            SampleImageAnalyzer {
                // TODO
            }
        )
    }
}

@Composable
fun CameraPreview(analyzer: ImageAnalysis.Analyzer) {
    val context = LocalContext.current
    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }
    val lifecycleOwner = LocalLifecycleOwner.current

    BoxWithConstraints {
        AndroidView(
            factory = { ctx ->
                val scaleType = PreviewView.ScaleType.FILL_CENTER
                val previewView = PreviewView(ctx).apply {
                    this.scaleType = scaleType
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT,
                    )
                    implementationMode = PreviewView.ImplementationMode.COMPATIBLE
                }
                val executor = ContextCompat.getMainExecutor(ctx)
                cameraProviderFuture.addListener(
                    {
                        bindCameraUseCases(
                            maxWidth,
                            maxHeight,
                            cameraProviderFuture,
                            previewView,
                            executor,
                            analyzer,
                            lifecycleOwner
                        )
                    },
                    executor
                )
                previewView
            },
            modifier = Modifier.fillMaxSize()
        )
    }
}

fun bindCameraUseCases(
    maxWidth: Dp,
    maxHeight: Dp,
    cameraProviderFuture: ListenableFuture<ProcessCameraProvider>,
    previewView: PreviewView,
    executor: Executor,
    analyzer: ImageAnalysis.Analyzer,
    lifecycleOwner: LifecycleOwner,
) {
    val screenAspectRatio = aspectRatio(width = maxWidth, height = maxHeight)
    val cameraProvider = cameraProviderFuture.get()
    val preview = Preview.Builder()
        .setTargetAspectRatio(screenAspectRatio)
        .build()
    val imageAnalysis = ImageAnalysis.Builder()
        .setTargetAspectRatio(screenAspectRatio)
        .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
        .build().apply {
            setAnalyzer(executor, analyzer)
        }
    val cameraSelector = CameraSelector.Builder()
        .requireLensFacing(CameraSelector.LENS_FACING_BACK)
        .build()

    cameraProvider.unbindAll()
    cameraProvider.bindToLifecycle(
        lifecycleOwner,
        cameraSelector,
        preview,
        imageAnalysis
    )
    preview.setSurfaceProvider(previewView.surfaceProvider)
}

private fun aspectRatio(width: Dp, height: Dp): Int {
    val previewRatio = max(width, height).value.toDouble() / min(width, height).value.toDouble()
    if (abs(previewRatio - RATIO_4_3_VALUE) <= abs(previewRatio - RATIO_16_9_VALUE)) {
        return AspectRatio.RATIO_4_3
    }
    return AspectRatio.RATIO_16_9
}

private const val RATIO_4_3_VALUE = 4.0 / 3.0
private const val RATIO_16_9_VALUE = 16.0 / 9.0

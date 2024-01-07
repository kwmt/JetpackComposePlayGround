package net.kwmt27.jetpackcomposeplayground.feature.camerax

import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy

class SampleImageAnalyzer(private val onChange: () -> Unit) : ImageAnalysis.Analyzer {
    override fun analyze(image: ImageProxy) {
        // TODO: Analyze image
        image.close()
        onChange()
    }
}

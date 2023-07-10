package net.kwmt27.jetpackcomposeplayground.slide.components

import androidx.compose.runtime.Composable

data class Slide(
    val content: @Composable () -> Unit,
)

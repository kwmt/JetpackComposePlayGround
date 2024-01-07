package com.github.kwmt.slide.components

import androidx.compose.runtime.Composable

data class Slide(
    val content: @Composable () -> Unit,
)

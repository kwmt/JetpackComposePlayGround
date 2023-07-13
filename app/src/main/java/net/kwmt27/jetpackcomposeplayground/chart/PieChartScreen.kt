package net.kwmt27.jetpackcomposeplayground.chart

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
internal fun PieChartScreen() {
    val chartColors = listOf(
        Color.Blue,
        Color.Green,
        Color.Red
    )
    val chartValues = listOf(60f, 110f, 20f)

    PieChart(
        modifier = Modifier.padding(20.dp),
        colors = chartColors,
        inputValues = chartValues,
        textColor = MaterialTheme.colors.secondaryVariant
    )
}

@Preview
@Composable
private fun PreviewPieChartScreen() {
    PieChartScreen()
}

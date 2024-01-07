package net.kwmt27.jetpackcomposeplayground.legacy.feature.box

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.addOutline
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import net.kwmt27.jetpackcomposeplayground.legacy.ui.theme.JetpackComposePlayGroundTheme

@Composable
fun BoxDashedBoarderSample() {
    BoxDashedBoarder()
}

@Composable
private fun BoxDashedBoarder() {
    Box(
        modifier = Modifier
            .size(width = 100.dp, height = 50.dp)
            // First, draw a background for your textField
            .background(
                color = Color(0xFFF2E4D4),
                shape = RoundedCornerShape(12.dp)
            )
            // Draw the dashed border
            .dashedBorder(
                color = Color(0xFFF58E61),
                shape = RoundedCornerShape(12.dp)
            )
    )
}

// https://medium.com/@kappdev/dashed-borders-in-jetpack-compose-a-comprehensive-guide-de990a944c4c
private fun Modifier.dashedBorder(
    color: Color,
    shape: Shape,
    strokeWidth: Dp = 1.dp,
    dashWidth: Dp = 4.dp,
    gapWidth: Dp = 4.dp,
    cap: StrokeCap = StrokeCap.Round,
) = this.drawWithContent {
    val outline = shape.createOutline(size, layoutDirection, this)
    val path = Path()
    path.addOutline(outline)
    val stroke = Stroke(
        cap = cap,
        width = strokeWidth.toPx(),
        pathEffect = PathEffect.dashPathEffect(
            intervals = floatArrayOf(dashWidth.toPx(), gapWidth.toPx()),
            phase = 0f
        )
    )

    this.drawContent()

    drawPath(
        path = path,
        style = stroke,
        color = color
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewBoxDashedBoarderSample() {
    JetpackComposePlayGroundTheme {
        BoxDashedBoarderSample()
    }
}

package com.ex2.ktmovies.ui.atoms

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import kotlin.math.PI
import kotlin.math.pow

fun Modifier.gradientBackground(colors: List<Color>, angle: Float) = this.then(
    Modifier.drawBehind {
        val angleRad = angle / 180f * PI
        val x = kotlin.math.cos(angleRad).toFloat() //Fractional x
        val y = kotlin.math.sin(angleRad).toFloat() //Fractional y

        val radius: Float = kotlin.math.sqrt(
            ((size.width.pow(2) + size.height.pow(2))) / 2f
        )
        val offset = center + Offset(x * radius, y * radius)

        val exactOffset = Offset(
            x = kotlin.math.min(offset.x.coerceAtLeast(0f), size.width),
            y = size.height - kotlin.math.min(offset.y.coerceAtLeast(0f), size.height)
        )

        drawRect(
            brush = Brush.linearGradient(
                colors = colors,
                start = Offset(size.width, size.height) - exactOffset,
                end = exactOffset
            ),
            size = size
        )
    }
)
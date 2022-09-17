package com.orglegal.fam.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = DarkPrimary,
    primaryVariant = DarkPrimary,
    secondary = DarkPrimary,
    surface = DarkSurface,
    onSurface = DarkOnSurface
)

private val LightColorPalette = lightColors(
    primary = LightPrimary,
    primaryVariant = LightPrimary,
    secondary = LightPrimary,
    surface = LightSurface,
    onSurface = LightOnSurface
)

@Composable
fun FeitoAMãoTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
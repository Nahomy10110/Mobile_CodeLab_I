package com.example.labii.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

private val LightColors  = lightColorScheme(
    primary = BluePrimary,
    secondary = BlueLight,
    background = BackgroundLight
)

@Composable
fun LoginTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColors,
        typography =  Typography,
        content = content
    )
}
package com.example.sazonify_v2.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    background = Color(0xFF121212),
    surface = Color(0xFF1E1E1E),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onTertiary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black
)

@Immutable
data class CustomColors(
    val background: Color,
    val cards: Color,
    val title: Color,
    val subtitle: Color,
    val special: Color
)

val LightCustomColors = CustomColors(
    background = Color(0xFFFCFAF8),
    cards = Color(0xFFF2ECE7),
    title = Color(0xFF000000),
    subtitle = Color(0xFF957C6F),
    special = Color(0xFFEE7E2B)
)

val DarkCustomColors = CustomColors(
    background = Color(0xFF121212),
    cards = Color(0xFF1E1E1E),
    title = Color(0xFFFFFFFF),
    subtitle = Color(0xFFB0A6A1),
    special = Color(0xFFFF8C42)
)

// Define un CompositionLocal para tus colores personalizados
private val LocalCustomColors = compositionLocalOf { LightCustomColors }

val MaterialTheme.customColors: CustomColors
    @Composable
    get() = LocalCustomColors.current

@Composable
fun Sazonify_v2Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+ (Material You)
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val customColors = if (darkTheme) DarkCustomColors else LightCustomColors

    CompositionLocalProvider(LocalCustomColors provides customColors) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = CustomTypography,
            content = content
        )
    }
}

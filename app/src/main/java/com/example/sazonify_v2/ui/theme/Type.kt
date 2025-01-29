package com.example.sazonify_v2.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.sazonify_v2.R


val Epilogue = FontFamily(
    Font(R.font.epilogue_regular),
    Font(R.font.epilogue_bold, FontWeight.Bold),
    Font(R.font.epilogue_light, FontWeight.Light),
    Font(R.font.epilogue_medium, FontWeight.Medium),
    Font(R.font.epilogue_semi_bold, FontWeight.SemiBold),
    Font(R.font.epilogue_extra_bold, FontWeight.ExtraBold),
    Font(R.font.epilogue_black, FontWeight.Black),
    Font(R.font.epilogue_thin, FontWeight.Thin),
    Font(R.font.epilogue_extra_light, FontWeight.ExtraLight),
)

val CustomTypography = Typography(
    bodyLarge = TextStyle(
        fontFamily = Epilogue,
        fontWeight = FontWeight.Normal
    ),
    titleLarge = TextStyle(
        fontFamily = Epilogue,
        fontWeight = FontWeight.Bold
    )
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)
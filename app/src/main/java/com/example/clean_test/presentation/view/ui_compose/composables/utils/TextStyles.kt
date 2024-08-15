package com.example.clean_test.presentation.view.ui_compose.composables.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object TextStyles {
    val ElevateButtonTextStyle = TextStyle(color = Color.White, fontFamily = FontFamily.SansSerif)

    val ElevatedCardsTextStyle = TextStyle(
        color = Color.Black,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        fontSize = 35.sp
    )
}
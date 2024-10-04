package com.example.clean_test.presentation.view.ui_compose.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.clean_test.presentation.view.ui_compose.composables.GetProverbsElevatedButton
import com.example.clean_test.presentation.view.ui_compose.theme.CustomViolet

@Composable
fun SecondScreen() {
    val columnModifier = Modifier.fillMaxSize()
    Column(
        modifier = columnModifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        GetProverbsElevatedButton(
            onButtonClick = {  },
            buttonColor = CustomViolet,
            buttonText = "Get Proverbs",
        )
    }
}
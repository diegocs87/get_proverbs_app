package com.example.clean_test.presentation.view.ui_compose.screens

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.clean_test.presentation.view.ui_compose.composables.CardsLazyColumnView
import com.example.clean_test.presentation.view.ui_compose.composables.GetProverbsElevatedButton
import com.example.clean_test.presentation.view.ui_compose.composables.OptionsTabsMenu
import com.example.clean_test.presentation.view.ui_compose.theme.CustomViolet
import com.example.clean_test.presentation.viewmodel.ProverbsViewModel

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
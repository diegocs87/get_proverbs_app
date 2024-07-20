package com.example.clean_test.presentation.view.ui_compose.screens

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.clean_test.presentation.utils.ProverbsUtils.getProverbStringFormat
import com.example.clean_test.presentation.utils.ProverbsUtils.showToastIfProverbIsEmpty
import com.example.clean_test.presentation.view.ui_compose.composables.TextLabelWithElevatedButton
import com.example.clean_test.presentation.view.ui_compose.theme.CustomViolet
import com.example.clean_test.presentation.viewmodel.ProverbsViewModel

object ProverbsMainScreen {

    @Composable
    fun Screen(proverbsViewModel: ProverbsViewModel, context: Context){
        val currentProverb by proverbsViewModel.currentProverb
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            currentProverb.showToastIfProverbIsEmpty(currentProverb,context)
            TextLabelWithElevatedButton(onButtonClick = { proverbsViewModel.update(context) }, buttonColor = CustomViolet,
                buttonText = "Get Proverbs", labelText = currentProverb.getProverbStringFormat(currentProverb))
        }
    }
}
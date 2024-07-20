package com.example.clean_test.presentation.utils

import android.content.Context
import android.widget.Toast
import com.example.clean_test.domain.entities.Proverbs
import com.example.clean_test.presentation.view.MainActivity

object ProverbsUtils {
     fun Proverbs.showToastIfProverbIsEmpty(currentProverb: Proverbs, context: Context) {
        if(currentProverb.proverb.isEmpty()) {
            Toast.makeText(context, MainActivity.ON_EMPTY_PROVERB_MESSAGE, Toast.LENGTH_LONG).show()
        }
    }

     fun Proverbs.getProverbStringFormat(currentProverb: Proverbs) = buildString {
        append(currentProverb.proverb)
        append(" src:  ")
        append(currentProverb.src)
    }
}
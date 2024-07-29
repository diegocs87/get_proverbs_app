package com.example.clean_test.presentation.view.ui_compose.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.clean_test.domain.entities.Proverbs

private val elevatedCarModifier = Modifier
    .padding(start = 10.dp, end = 10.dp)
    .fillMaxWidth()


@Composable
fun CardsLazyColumnView(proverbsList:List<Proverbs>){
    LazyColumn(contentPadding = PaddingValues(15.dp)){
        items(proverbsList){
            listItemRow(it)
            HorizontalDivider()
        }
    }
}

@Composable
fun listItemRow(currentProverb: Proverbs) {
    ElevatedCard(modifier = elevatedCarModifier) {
        Text(text = currentProverb.toString())
    }
}
package com.example.clean_test.presentation.view.ui_compose.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clean_test.domain.entities.Proverbs

private val elevatedCarModifier = Modifier
    .padding(start = 10.dp, end = 10.dp)
    .fillMaxWidth()


@Composable
fun CardsLazyColumnView(proverbsList:List<Proverbs>){
    LazyColumn(verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier.padding(top = 10.dp).fillMaxSize(0.9f)){
        items(proverbsList){
            listItemRow(it)
        }
    }
}

@Composable
fun listItemRow(currentProverb: Proverbs) {
    ElevatedCard(modifier = elevatedCarModifier) {
        Text(currentProverb.toString(),
            color = Color.Black,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 35.sp,
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp, bottom = 5.dp)
                .fillMaxSize())
    }
}
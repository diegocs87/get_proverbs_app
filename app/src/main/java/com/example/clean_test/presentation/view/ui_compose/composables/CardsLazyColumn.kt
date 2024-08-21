package com.example.clean_test.presentation.view.ui_compose.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.clean_test.domain.entities.Proverbs

private val lazyColumnModifier = Modifier
    .fillMaxWidth()
    .fillMaxSize(0.9f)
    .padding(top = 20.dp)

const val PICTURE_URL =
    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/female/25.png"


@Composable
fun CardsLazyColumnView(proverbsList: List<Proverbs>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(20.dp), modifier = lazyColumnModifier
    ) {
        items(proverbsList) { proverb ->
            setElevatedCardWith(proverb, PICTURE_URL)
        }
    }
}
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
    .fillMaxSize()
    .padding(top = 10.dp)

const val PICTURE_URL =
    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/female/25.png"


@Composable
fun ProverbsCardLazyColumnView(proverbsList: List<Proverbs>, page: Int) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(20.dp), modifier = lazyColumnModifier
    ) {
        items(proverbsList) { proverb ->
            SetElevatedCardWith(proverb, PICTURE_URL, page)
        }
    }
}

@Composable
fun FavoritesCardLazyColumnView(favoritesList: List<Proverbs>, page: Int) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(20.dp), modifier = lazyColumnModifier
    ) {
        items(favoritesList) { favorites ->
            SetElevatedCardWith(favorites, PICTURE_URL, page)
        }
    }
}
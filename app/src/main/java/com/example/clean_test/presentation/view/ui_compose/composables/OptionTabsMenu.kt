package com.example.clean_test.presentation.view.ui_compose.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.clean_test.R
import com.example.clean_test.domain.entities.Proverbs
import com.example.clean_test.presentation.viewmodel.FavoritesViewModel
import com.example.clean_test.presentation.viewmodel.ProverbsViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OptionsTabsMenu(proverbsViewModel: ProverbsViewModel, favoritesViewModel: FavoritesViewModel) {
    val tabsTittleList = listOf("Main", "Favorites", "Next")
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val proverbsList by proverbsViewModel.proverbsList.collectAsState()
    val favoritesList by favoritesViewModel.favoritesList.collectAsState()

    TabRow(
        selectedTabIndex = selectedTabIndex, modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize(0.08f)
    ) {
        tabsTittleList.forEachIndexed { tabIndex, tittle ->
            Tab(selected = isSelected(tabIndex, selectedTabIndex), onClick = {
                selectedTabIndex = tabIndex
                getFavoritesList(selectedTabIndex, favoritesViewModel)
            }) {
                Icon(
                    painter = painterResource(getResourceOfTab(tabIndex)),
                    contentDescription = tittle
                )
                Text(tittle)
            }
        }
    }


    val pagerState = rememberPagerState(pageCount = { tabsTittleList.size })

    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }

    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress) {
            selectedTabIndex = pagerState.currentPage
        }
    }

    HorizontalPager(
        state = pagerState, modifier = Modifier.fillMaxSize(0.9f)
    ) { page ->
        SetScreenData(page, proverbsList, favoritesList)
    }

}

@Composable
private fun SetScreenData(
    page: Int, proverbsList: List<Proverbs>, favoritesList: List<Proverbs>
) {
    when (page) {
        0 -> ProverbsCardLazyColumnView(proverbsList = proverbsList, page)
        1 -> FavoritesCardLazyColumnView(favoritesList = favoritesList, page)
    }
}

private fun getFavoritesList(
    selectedTabIndex: Int, favoritesViewModel: FavoritesViewModel
) {
    if (selectedTabIndex == 1) {
        favoritesViewModel.getFavorites()
    }
}

private fun isSelected(tabIndex: Int, selectedTabIndex: Int) = tabIndex == selectedTabIndex

private fun getResourceOfTab(id: Int): Int {
    return when (id) {
        0 -> R.drawable.main_icon
        1 -> R.drawable.fav_icon
        3 -> R.drawable.next_icon
        else -> R.drawable.main_icon
    }
}
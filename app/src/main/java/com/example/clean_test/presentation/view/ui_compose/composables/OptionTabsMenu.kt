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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.example.clean_test.R
import com.example.clean_test.domain.entities.Proverbs
import com.example.clean_test.presentation.viewmodel.ProverbsViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OptionsTabsMenu(proverbsList: List<Proverbs>, proverbsViewModel: ProverbsViewModel) {
    val tabsTittleList = listOf("Main", "Favorites", "Next")
    var selectedTabIndex by remember { mutableStateOf(0) }
    val favoritesList by proverbsViewModel.favoritesList

    TabRow(
        selectedTabIndex = selectedTabIndex, modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize(0.08f)
    ) {
        tabsTittleList.forEachIndexed { tabIndex, tittle ->
            Tab(selected = isSelected(tabIndex, selectedTabIndex), onClick = {
                selectedTabIndex = tabIndex
                getFavoritesList(selectedTabIndex, proverbsViewModel)
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
        setScreenData(page, proverbsList, favoritesList)
        Text(
            text = "Page: $page", fontSize = 32.sp, modifier = Modifier.fillMaxSize()
        )
    }

}

@Composable
private fun setScreenData(
    page: Int, proverbsList: List<Proverbs>, favoritesList: List<Proverbs>
) {
    when (page) {
        0 -> CardsLazyColumnView(proverbsList = proverbsList)
        1 -> CardsLazyColumnView(proverbsList = favoritesList)
        else -> {}
    }
}

private fun getFavoritesList(
    selectedTabIndex: Int, proverbsViewModel: ProverbsViewModel
) {
    if (selectedTabIndex == 1) {
        proverbsViewModel.getFavorites()
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
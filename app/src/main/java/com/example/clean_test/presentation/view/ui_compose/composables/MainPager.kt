package com.example.clean_test.presentation.view.ui_compose.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.clean_test.domain.entities.Proverbs

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainPager(numberOfPages:Int, proverbsList: List<Proverbs>){
    // Estado del Pager
    val pagerState = rememberPagerState(pageCount = {numberOfPages})

    // Componente HorizontalPager
    HorizontalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize(0.9f)
    ) { page ->
        if(page == 0 ){
            CardsLazyColumnView(proverbsList = proverbsList)
        }
        Text(
            text = "Page: $page",
            fontSize = 32.sp,
            modifier = Modifier.fillMaxSize()
        )
    }
}

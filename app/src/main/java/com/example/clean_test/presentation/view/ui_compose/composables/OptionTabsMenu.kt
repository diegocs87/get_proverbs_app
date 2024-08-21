package com.example.clean_test.presentation.view.ui_compose.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.clean_test.R

@Composable
fun OptionsTabsMenu() {
    val tabsTittleList = listOf("Main", "Favorites", "Next")
    var selectedTabIndex by remember { mutableStateOf(0) }
    TabRow(
        selectedTabIndex = selectedTabIndex, modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize(0.08f)
    ) {
        tabsTittleList.forEachIndexed { tabIndex, tittle ->
            Tab(selected = isSelected(tabIndex, selectedTabIndex),
                onClick = { selectedTabIndex = tabIndex }) {
                Icon(
                    painter = painterResource(getResourceOfTab(tabIndex)),
                    contentDescription = tittle
                )
                Text(tittle)
            }
        }
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
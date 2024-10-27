package com.example.clean_test.presentation.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.ComposeView
import com.example.clean_test.databinding.ActivityMainBinding
import com.example.clean_test.presentation.view.ui_compose.screens.ProverbsMainScreen
import com.example.clean_test.presentation.viewmodel.FavoritesViewModel
import com.example.clean_test.presentation.viewmodel.ProverbsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val proverbsViewModel: ProverbsViewModel by viewModels()
    private val favoritesViewModel: FavoritesViewModel by viewModels()
    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var composeView: ComposeView

    companion object {
        const val ON_EMPTY_PROVERB_MESSAGE = "No proverbs available, please try again."
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        composeView = mainBinding.mainComposeContainer
        setContentView(mainBinding.root)
        initView(proverbsViewModel)
    }

    private fun initView(proverbsViewModel: ProverbsViewModel) {
        composeView.setContent {
            ProverbsMainScreen(proverbsViewModel = proverbsViewModel, favoritesViewModel = favoritesViewModel, context = this@MainActivity)
        }
    }
}
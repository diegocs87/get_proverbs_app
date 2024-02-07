package com.example.clean_test.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.clean_test.databinding.ActivityMainBinding
import com.example.clean_test.presentation.viewmodel.ProverbsViewModel

class MainActivity : AppCompatActivity() {
    private val proverbsViewModel: ProverbsViewModel by viewModels()
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        configureViewModelObserver()
        configureClickListenerOnGetProverbsButton()
    }

    private fun configureViewModelObserver(){
        proverbsViewModel.currentProverb.observe(this) { currentProverb ->
            mainBinding.msjTv.text = buildString {
                append(currentProverb.proverb)
                append(" src:  ")
                append(currentProverb.src)
            }
        }
    }

    private fun configureClickListenerOnGetProverbsButton(){
        mainBinding.getProverbsButton.setOnClickListener {
            proverbsViewModel.update()
        }
    }
}
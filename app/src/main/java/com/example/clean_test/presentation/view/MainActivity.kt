package com.example.clean_test.presentation.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.clean_test.databinding.ActivityMainBinding
import com.example.clean_test.presentation.viewmodel.ProverbsViewModel

class MainActivity : AppCompatActivity() {
    private val proverbsViewModel: ProverbsViewModel by viewModels()
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        initObservers()
        initListeners()
    }

    private fun initObservers() {
        proverbsViewModel.currentProverb.observe(this) { currentProverb ->
            mainBinding.msjTv.text = buildString {
                append(currentProverb.proverb)
                append(" src:  ")
                append(currentProverb.src)
            }
        }
    }

    private fun initListeners(){
        initListenerOnGetProverbsButton()
    }

    private fun initListenerOnGetProverbsButton(){
        mainBinding.getProverbsButton.setOnClickListener {
            proverbsViewModel.update(this)
        }
    }
}
package com.example.clean_test.presentation.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.clean_test.databinding.ActivityMainBinding
import com.example.clean_test.domain.entities.Proverbs
import com.example.clean_test.presentation.viewmodel.ProverbsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val proverbsViewModel: ProverbsViewModel by viewModels()
    private lateinit var mainBinding: ActivityMainBinding
    companion object{
        const val ON_EMPTY_PROVERB_MESSAGE = "No proverbs available, please try again."
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        initObservers()
        initListeners()
    }

    private fun initObservers() {
        proverbsViewModel.currentProverb.observe(this) { currentProverb ->
            showProverbOnScreen(currentProverb)
        }
    }

    private fun showProverbOnScreen(proverbs:List<Proverbs>){
        if(proverbs.isNotEmpty()) {
            val currentProverb = proverbs[(proverbs.indices).random()]
            buildProverbToShow(currentProverb)
        }else {
            Toast.makeText(this, ON_EMPTY_PROVERB_MESSAGE,Toast.LENGTH_LONG).show()
        }
    }

    private fun buildProverbToShow(currentProverb:Proverbs){
        mainBinding.msjTv.text = buildString {
            append(currentProverb.proverb)
            append(" src:  ")
            append(currentProverb.src)
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
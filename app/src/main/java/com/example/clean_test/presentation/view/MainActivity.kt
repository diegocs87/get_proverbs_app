package com.example.clean_test.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.clean_test.data.network.NetworkConnectionVerifierImplementation
import com.example.clean_test.databinding.ActivityMainBinding
import com.example.clean_test.presentation.viewmodel.ProverbsViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val proverbsViewModel: ProverbsViewModel by viewModels{ProverbsViewModel.Factory}
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
        val networkConnectionVerifierImplementation = NetworkConnectionVerifierImplementation()
        mainBinding.getProverbsButton.setOnClickListener {
            proverbsViewModel.update(this)
            CoroutineScope(Dispatchers.IO).launch {
                networkConnectionVerifierImplementation.verify(this@MainActivity)
            }
        }
    }
}
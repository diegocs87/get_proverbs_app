package com.example.clean_test.presentation.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clean_test.databinding.ActivityMainBinding
import com.example.clean_test.domain.entities.Proverbs
import com.example.clean_test.presentation.viewmodel.ProverbsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val proverbsViewModel: ProverbsViewModel by viewModels()
    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var composeView: ComposeView
    companion object{
        const val ON_EMPTY_PROVERB_MESSAGE = "No proverbs available, please try again."
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        composeView = mainBinding.mainComposeContainer
        setContentView(mainBinding.root)
        initObservers()
        initListeners()
        initComposeView()
    }

    private fun initComposeView(){
        composeView.setContent {
            Column(modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.height(30.dp))
                Text(text = "hola mundo", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
        }
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
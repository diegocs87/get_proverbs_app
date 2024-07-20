package com.example.clean_test.presentation.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clean_test.databinding.ActivityMainBinding
import com.example.clean_test.domain.entities.Proverbs
import com.example.clean_test.presentation.view.theme.CustomViolet
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
        initComposeView(proverbsViewModel)
    }

    private fun initComposeView(proverbsViewModel: ProverbsViewModel){
        composeView.setContent {
            ProverbsScreen(proverbsViewModel = proverbsViewModel)
        }
    }
    
    @Composable
    private fun ProverbsScreen(proverbsViewModel: ProverbsViewModel){
        val currentProverb by proverbsViewModel.currentProverb
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            showToastIfProverbIsEmpty(currentProverb)
            Text(text = getProverbStringFormat(currentProverb), fontWeight = Bold, fontSize = 30.sp)
            Spacer(modifier = Modifier.height(40.dp))
            ElevatedButton(onClick = { proverbsViewModel.update(this@MainActivity)}, colors = ButtonDefaults.buttonColors(containerColor = CustomViolet)) {
                Text("Get Proverbs",
                    color = Color.White,
                    fontFamily = FontFamily.SansSerif)
            }
        }
    }

    private fun showToastIfProverbIsEmpty(currentProverb: Proverbs) {
        if(currentProverb.proverb.isEmpty()) {
            Toast.makeText(this, ON_EMPTY_PROVERB_MESSAGE,Toast.LENGTH_LONG).show()
        }
    }

    private fun getProverbStringFormat(currentProverb:Proverbs) = buildString {
        append(currentProverb.proverb)
        append(" src:  ")
        append(currentProverb.src)
    }
}
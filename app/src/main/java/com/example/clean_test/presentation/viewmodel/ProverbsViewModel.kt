package com.example.clean_test.presentation.viewmodel

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clean_test.domain.entities.Proverbs
import com.example.clean_test.domain.services.GetProverbsUseCase
import com.example.clean_test.presentation.di.qualifiers.GetProverbsUseCaseImplementationQualifier
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProverbsViewModel
    @Inject constructor(@GetProverbsUseCaseImplementationQualifier private val getProverbsUseCase:GetProverbsUseCase)
    :ViewModel() {
    private var randomProverb = Proverbs("","")
    private val _currentProverb = mutableStateOf(randomProverb)
    val currentProverb: State<Proverbs> = _currentProverb

    private lateinit var proverbs: List<Proverbs>

    fun update(context: Context){
        viewModelScope.launch {
            proverbs = getProverbsUseCase.get(context)
            updateCurrentProverbWithRetrievedData()
        }
    }

    private fun updateCurrentProverbWithRetrievedData() {
        if (proverbs.isNotEmpty()) {
            randomProverb = proverbs[(proverbs.indices).random()]
        }
        _currentProverb.value = randomProverb
    }
}
package com.example.clean_test.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
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
    val currentProverb = MutableLiveData<List<Proverbs>>()
    private lateinit var proverbs: List<Proverbs>

    fun update(context: Context){
        viewModelScope.launch {
            proverbs = getProverbsUseCase.get(context)
            currentProverb.postValue(proverbs)
        }
    }
}
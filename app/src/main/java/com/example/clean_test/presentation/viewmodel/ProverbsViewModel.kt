package com.example.clean_test.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clean_test.domain.model.Proverbs
import com.example.clean_test.presentation.factory.UseCaseFactory
import kotlinx.coroutines.launch

class ProverbsViewModel:ViewModel() {
    val currentProverb = MutableLiveData<Proverbs>()
    private val getProverbsUseCase = UseCaseFactory().get()
    private lateinit var proverbsList: List<Proverbs>

    fun update(context: Context){
        viewModelScope.launch { proverbsList = getProverbsUseCase.get(context)
            currentProverb.postValue(proverbsList[(proverbsList.indices).random()])
        }
    }
}
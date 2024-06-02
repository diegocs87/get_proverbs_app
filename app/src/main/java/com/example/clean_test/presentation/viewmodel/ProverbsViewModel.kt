package com.example.clean_test.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clean_test.domain.entities.Proverbs
import com.example.clean_test.presentation.di.UseCaseCreator
import kotlinx.coroutines.launch

class ProverbsViewModel:ViewModel() {
    val currentProverb = MutableLiveData<Proverbs>()
    private lateinit var proverbs: List<Proverbs>

    fun update(context: Context){
        val getProverbsUseCase = UseCaseCreator().getProverbsUseCase(context)
        viewModelScope.launch {
            proverbs = getProverbsUseCase.get(context)
            currentProverb.postValue(proverbs[(proverbs.indices).random()])
        }
    }
}
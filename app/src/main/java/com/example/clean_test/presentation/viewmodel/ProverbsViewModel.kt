package com.example.clean_test.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.clean_test.domain.model.Proverbs
import com.example.clean_test.presentation.factory.UseCaseFactory

class ProverbsViewModel:ViewModel() {
    val currentProverb = MutableLiveData<Proverbs>()
    private val getProverbsUseCase = UseCaseFactory().get()
    private lateinit var proverbsList: List<Proverbs>

    fun update(){
        proverbsList = getProverbsUseCase.get()
        currentProverb.postValue(proverbsList[(proverbsList.indices).random()])
    }
}
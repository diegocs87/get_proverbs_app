package com.example.clean_test.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.clean_test.data.ProverbsRepositoryImplementation
import com.example.clean_test.domain.model.Proverbs
import com.example.clean_test.domain.usecase.GetProverbsUseCaseImplementation

class ProverbsViewModel:ViewModel() {
    val currentProverb = MutableLiveData<Proverbs>()
    private val getProverbsUseCase = GetProverbsUseCaseImplementation(ProverbsRepositoryImplementation())  // Está bien inyectar el repository desde el model?
    lateinit var proverbsList: List<Proverbs>

    fun getProverbs(){
        proverbsList = getProverbsUseCase.getProverbs()
        currentProverb.postValue(proverbsList[(proverbsList.indices).random()])
    }
}
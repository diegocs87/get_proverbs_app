package com.example.clean_test.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.clean_test.domain.model.Proverbs
import com.example.clean_test.domain.usecase.GetProverbsUseCase
import com.example.clean_test.presentation.di.UseCaseCreator
import kotlinx.coroutines.launch

class ProverbsViewModel(private val getProverbsUseCase: GetProverbsUseCase):ViewModel() {
    val currentProverb = MutableLiveData<Proverbs>()
    private lateinit var proverbs: List<Proverbs>

    fun update(context: Context){
        viewModelScope.launch { proverbs = getProverbsUseCase.get(context)
            currentProverb.postValue(proverbs[(proverbs.indices).random()])
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val getProverbsUseCase = UseCaseCreator().getProverbsUseCase()
                ProverbsViewModel(getProverbsUseCase)
            }
        }
    }
}
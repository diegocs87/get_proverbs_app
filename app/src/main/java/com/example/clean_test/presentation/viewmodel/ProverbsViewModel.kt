package com.example.clean_test.presentation.viewmodel

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clean_test.domain.entities.Proverbs
import com.example.clean_test.domain.usecases.AddFavorite
import com.example.clean_test.domain.usecases.GetProverbsUseCase
import com.example.clean_test.domain.usecases.RemoveFavorite
import com.example.clean_test.presentation.di.qualifiers.AddFavoriteUseCaseImplementationQualifier
import com.example.clean_test.presentation.di.qualifiers.GetProverbsUseCaseImplementationQualifier
import com.example.clean_test.presentation.di.qualifiers.IODispatcher
import com.example.clean_test.presentation.di.qualifiers.RemoveFavoriteUseCaseImplementationQualifier
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ProverbsViewModel
@Inject constructor(
    @GetProverbsUseCaseImplementationQualifier private val getProverbsUseCase: GetProverbsUseCase,
    @AddFavoriteUseCaseImplementationQualifier private val addFavoriteUseCase: AddFavorite,
    @RemoveFavoriteUseCaseImplementationQualifier private val removeFavoriteUseCase: RemoveFavorite,
    @IODispatcher private val dispatcher: CoroutineDispatcher
) : ViewModel() {
    private var randomProverb = emptyList<Proverbs>()
    private val _proverbsList = mutableStateOf(randomProverb)
    val proverbsList: State<List<Proverbs>> get() = _proverbsList
    private lateinit var proverbs: List<Proverbs>

    fun update(context: Context) {
        viewModelScope.launch {
            withContext(dispatcher) {
                proverbs = getProverbsUseCase.get(context)
            }
            updateCurrentProverbWithRetrievedData()
        }
    }

    fun removeFavorite(favorite: Proverbs){
        viewModelScope.launch {
            withContext(dispatcher) {
                removeFavoriteUseCase.invoke(favorite)
            }
        }
    }

    fun addFavorite(favorite:Proverbs) {
        viewModelScope.launch {
            withContext(dispatcher) {
                addFavoriteUseCase.invoke(favorite)
            }
        }
    }

    private fun updateCurrentProverbWithRetrievedData() {
        if (proverbs.isNotEmpty()) {
            _proverbsList.value = proverbs
        }
    }
}
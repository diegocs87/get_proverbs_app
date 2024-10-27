package com.example.clean_test.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clean_test.domain.entities.Proverbs
import com.example.clean_test.domain.usecases.GetProverbsUseCase
import com.example.clean_test.presentation.di.qualifiers.GetProverbsUseCaseImplementationQualifier
import com.example.clean_test.presentation.di.qualifiers.IODispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ProverbsViewModel
@Inject constructor(
    @GetProverbsUseCaseImplementationQualifier private val getProverbsUseCase: GetProverbsUseCase,
    @IODispatcher private val dispatcher: CoroutineDispatcher
) : ViewModel() {
    private var randomProverb = emptyList<Proverbs>()
    private val _proverbsList = MutableStateFlow(randomProverb)
    val proverbsList: StateFlow<List<Proverbs>> get() = _proverbsList
    private lateinit var proverbs: List<Proverbs>

    fun update(context: Context) {
        viewModelScope.launch {
            withContext(dispatcher) {
                proverbs = getProverbsUseCase.get(context)
            }
            updateCurrentProverbWithRetrievedData()
        }
    }

    private fun updateCurrentProverbWithRetrievedData() {
        if (proverbs.isNotEmpty()) {
            _proverbsList.value = proverbs
        }
    }
}


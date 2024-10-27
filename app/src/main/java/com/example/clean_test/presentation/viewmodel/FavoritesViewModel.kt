package com.example.clean_test.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clean_test.domain.entities.Proverbs
import com.example.clean_test.domain.usecases.AddFavorite
import com.example.clean_test.domain.usecases.GetFavorites
import com.example.clean_test.domain.usecases.RemoveFavorite
import com.example.clean_test.presentation.di.qualifiers.AddFavoriteUseCaseImplementationQualifier
import com.example.clean_test.presentation.di.qualifiers.GetFavoritesUseCaseImplementationQualifier
import com.example.clean_test.presentation.di.qualifiers.IODispatcher
import com.example.clean_test.presentation.di.qualifiers.RemoveFavoriteUseCaseImplementationQualifier
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    @GetFavoritesUseCaseImplementationQualifier private val getFavoritesUseCase: GetFavorites,
    @AddFavoriteUseCaseImplementationQualifier private val addFavoriteUseCase: AddFavorite,
    @RemoveFavoriteUseCaseImplementationQualifier private val removeFavoriteUseCase: RemoveFavorite,
    @IODispatcher private val dispatcher: CoroutineDispatcher
) : ViewModel() {
    private var randomProverb = emptyList<Proverbs>()
    private val _favoritesList = MutableStateFlow(randomProverb)
    val favoritesList: StateFlow<List<Proverbs>> get() = _favoritesList
    private lateinit var favorites: List<Proverbs>
    private val _favoritesState = mutableStateOf<Map<Proverbs, Boolean>>(emptyMap())

    fun getFavorites() {
        viewModelScope.launch {
            withContext(dispatcher) {
                favorites = getFavoritesUseCase.invoke()
            }
            updateFavoritesListWithRetrievedData()
        }
    }

    fun removeFavorite(favorite: Proverbs) {
        viewModelScope.launch {
            withContext(dispatcher) {
                removeFavoriteUseCase.invoke(favorite)
                favorites = getFavoritesUseCase.invoke()
            }
            updateFavoritesListWithRetrievedData()
        }
    }

    fun addFavorite(favorite: Proverbs) {
        viewModelScope.launch {
            withContext(dispatcher) {
                addFavoriteUseCase.invoke(favorite)
            }
        }
    }

    fun toggleFavorite(proverbId: Proverbs) {
        val currentState = _favoritesState.value
        val newState = currentState.toMutableMap().apply {
            this[proverbId] = !(this[proverbId] ?: false)
        }
        _favoritesState.value = newState
    }

    private fun updateFavoritesListWithRetrievedData() {
        _favoritesList.value = favorites
    }

    fun isFavorite(currentProverb: Proverbs): Boolean {
        return _favoritesState.value[currentProverb] ?: false
    }
}
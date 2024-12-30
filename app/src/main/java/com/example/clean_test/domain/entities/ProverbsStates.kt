package com.example.clean_test.domain.entities

sealed class ProverbsStates {
    data object Loading:ProverbsStates()
    data class OnSuccessRetrieved(val retrievedProverbs: List<Proverbs>):ProverbsStates()
    data class OnError(val errorMsg:String):ProverbsStates()
}
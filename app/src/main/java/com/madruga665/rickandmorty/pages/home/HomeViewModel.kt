package com.madruga665.rickandmorty.pages.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.madruga665.rickandmorty.models.Character
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    val repository = CharacterRepository()
    val characters = MutableLiveData<List<Character>>()

    init {
        fetchCharacters()
    }

    fun fetchCharacters() {
        viewModelScope.launch {
            try {
                val response = repository.getCharacters()
                characters.value = response
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }
}
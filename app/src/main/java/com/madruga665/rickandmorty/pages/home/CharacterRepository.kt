package com.madruga665.rickandmorty.pages.home

import com.madruga665.rickandmorty.models.Character

class CharacterRepository {
    private val characterApi = CharacterApi.api

    suspend fun getCharacters(): List<Character> {
        return characterApi.getCharacters().results
    }

}
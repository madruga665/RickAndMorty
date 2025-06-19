package com.madruga665.rickandmorty.models

data class Character(val id: Int, val name: String, val image: String)

data class Response(val results: List<Character>)
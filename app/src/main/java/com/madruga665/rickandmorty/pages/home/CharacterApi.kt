package com.madruga665.rickandmorty.pages.home

import com.madruga665.rickandmorty.models.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Endpoint {
    @GET("character")
    suspend fun getCharacters(): Response
}

object CharacterApi {
    private const val path = "https://rickandmortyapi.com/api/"

    val api: Endpoint by lazy {
        Retrofit.Builder()
            .baseUrl(path)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Endpoint::class.java)
    }
}


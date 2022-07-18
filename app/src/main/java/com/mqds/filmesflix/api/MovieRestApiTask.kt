package com.mqds.filmesflix.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieRestApiTask {
    //criando constantes
    companion object{
        const val BASE_URL = "https://marcelqds.github.io/filmes-flix-bootcamp-api/"
    }

    private fun movieProvider(): Retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun retrofiApi(): MovieApi = movieProvider().create(MovieApi::class.java)
}
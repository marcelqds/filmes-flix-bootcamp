package com.mqds.filmesflix.api

import com.mqds.filmesflix.domain.Movie
import retrofit2.Call
import retrofit2.http.GET

interface MovieApi {
    // https://raw.githubusercontent.com/natanfelipe/FilmesFlixJson/master/moviesList
    // https://marcelqds.github.io/filmes-flix-bootcamp-api/films.json
    @GET("films.json")
    fun getAllMovies(): Call<List<Movie>>


}


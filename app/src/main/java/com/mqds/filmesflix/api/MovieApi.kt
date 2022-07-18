package com.mqds.filmesflix.api

import com.mqds.filmesflix.model.Movie
import retrofit2.http.GET

interface MovieApi {
    // https://raw.githubusercontent.com/natanfelipe/FilmesFlixJson/master/moviesList
    // https://marcelqds.github.io/filmes-flix-bootcamp-api/films.json
    @GET("films.json")
    fun getAllMovies(): List<Movie>


}


package com.mqds.filmesflix.data

import com.mqds.filmesflix.api.MovieApi

interface MovieDataSource {
    fun getAllMovies(): List<MovieApi>
}
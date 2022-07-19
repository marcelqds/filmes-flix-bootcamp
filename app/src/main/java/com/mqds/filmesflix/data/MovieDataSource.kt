package com.mqds.filmesflix.data

import com.mqds.filmesflix.domain.Movie

interface MovieDataSource {
    fun getAllMovies(): List<Movie>
}
package com.mqds.filmesflix.usecase

import com.mqds.filmesflix.data.MovieRepository

class MovieListUseCase(private val movieRepository: MovieRepository) {

    operator fun invoke() = movieRepository.getAllMoviesFromDataSource()

}
package com.mqds.filmesflix.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mqds.filmesflix.model.Movie

class MovieListViewModel: ViewModel() {

    private val listOfMoveis = arrayListOf(
        Movie(
            id = 0,
            title = "Titanic",
            description = null,
            image = "",
            lauchDate = null
        ),

        Movie(
            id = 1,
            title = "Central do Brasil",
            description = null,
            image = "",
            lauchDate = null
        ),
        Movie(
            id = 2,
            title = "Carandiru",
            description = null,
            image = "",
            lauchDate = null
        )
    )

    private var _moviesList = MutableLiveData<List<Movie>>()
    val moviesList: LiveData<List<Movie>>
    get() = _moviesList

    fun init(){
        getAllMovies()
    }

    private fun getAllMovies(){
        _moviesList.value = listOfMoveis
    }
}
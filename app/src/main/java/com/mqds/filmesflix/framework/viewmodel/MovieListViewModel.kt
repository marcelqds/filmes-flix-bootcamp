package com.mqds.filmesflix.framework.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mqds.filmesflix.framework.api.MovieRestApiTask
import com.mqds.filmesflix.data.MovieRepository
import com.mqds.filmesflix.domain.Movie
import com.mqds.filmesflix.implentations.MovieDataSourceImplementation
import com.mqds.filmesflix.usecase.MovieListUseCase

class MovieListViewModel: ViewModel() {
    companion object {
        const val TAG = "VIEWMODEL_ERROR"
    }

    private val movieRestApiTask = MovieRestApiTask()
    private val movieDataSource = MovieDataSourceImplementation(movieRestApiTask)
    private val movieRepository = MovieRepository(movieDataSource)
    private val movieListUseCase = MovieListUseCase(movieRepository)

    private var _moviesList = MutableLiveData<List<Movie>>()
    val moviesList: LiveData<List<Movie>>
    get() = _moviesList

    fun init(){
        getAllMovies()
    }

    private fun getAllMovies(){
        Thread {
            try{
                _moviesList.postValue(movieListUseCase.invoke())
            }catch(e: Exception){
                Log.w(TAG, e.message.toString())
            }
        }.start()
    }
}
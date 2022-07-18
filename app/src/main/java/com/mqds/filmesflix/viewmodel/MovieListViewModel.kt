package com.mqds.filmesflix.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mqds.filmesflix.api.MovieRestApiTask
import com.mqds.filmesflix.domain.Movie
import com.mqds.filmesflix.repository.MovieRepository
import java.lang.Exception

class MovieListViewModel: ViewModel() {
    companion object {
        const val TAG = "VIEWMODEL_ERROR"
    }

    private val movieRestApiTask = MovieRestApiTask()
    private val movieRepository = MovieRepository(movieRestApiTask)

    private var _moviesList = MutableLiveData<List<Movie>>()
    val moviesList: LiveData<List<Movie>>
    get() = _moviesList

    fun init(){
        getAllMovies()
    }

    private fun getAllMovies(){
        // Não rodar dessa forma, dará erro pois executará na Thread principal, ela responsável por exebir os componentes do usuário, as views.
        Thread {
            try{
                _moviesList.postValue(movieRepository.getAllMovie())
            }catch(e: Exception){
                Log.w(TAG, e.message.toString())
            }
        }.start()
    }
}
package com.mqds.filmesflix.repository

import android.util.Log
import com.mqds.filmesflix.api.MovieRestApiTask
import com.mqds.filmesflix.model.Movie

class MovieRepository(private val movieRestApiTask: MovieRestApiTask){
    companion object{
        const val TAG = "REPOSITORY_ERROR"
    }
    private var movieList = arrayListOf<Movie>()

    fun getAllMovie(): List<Movie>{
        val request = movieRestApiTask.retrofiApi().getAllMovies().execute()

        if(request.isSuccessful){
            request.body()?.let {
                Log.w("REPOS::",it.toString())
                movieList.addAll(it)
            }
        }else{
            request.errorBody()?.let {
                Log.w(TAG,it.toString())
            }
        }

        return movieList
    }
}
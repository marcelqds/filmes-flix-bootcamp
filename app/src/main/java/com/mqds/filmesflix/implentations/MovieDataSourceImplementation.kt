package com.mqds.filmesflix.implentations

import android.util.Log
import com.mqds.filmesflix.framework.api.MovieRestApiTask
import com.mqds.filmesflix.data.MovieDataSource
import com.mqds.filmesflix.domain.Movie

class MovieDataSourceImplementation(private val movieRestApiTask: MovieRestApiTask): MovieDataSource {

    companion object{
        const val TAG = "DATASOURCE_IMPLEMEN"
    }

    private val movieList = arrayListOf<Movie>()

    override fun getAllMovies(): List<Movie> {

        val request = movieRestApiTask.retrofiApi().getAllMovies().execute()
        if (request.isSuccessful) {
            request.body()?.let{
                movieList.addAll(it)
            }
        }else {
            request.errorBody()?.let {
                Log.w(TAG, it.toString())
            }
        }

        return movieList
    }

}
package com.mqds.filmesflix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mqds.filmesflix.databinding.ActivityMainBinding
import com.mqds.filmesflix.model.Movie
import com.mqds.filmesflix.viewmodel.MovieListViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;
    private lateinit var movieListViewModel: MovieListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        movieListViewModel = ViewModelProvider.NewInstanceFactory().create(MovieListViewModel::class.java)
        movieListViewModel.init()
        initObserver()
        loadingVisibility(true)
    }

    private fun initObserver(){
        movieListViewModel.moviesList.observe(this, Observer { list ->
            if(list.isNotEmpty()){
                populateList(list)
                loadingVisibility(false)
            }

        })
    }

    private fun populateList(movies: List<Movie>){
        binding.moviesList.apply {
            hasFixedSize()
            adapter = MovieAdapter(movies)
        }
    }

    private fun loadingVisibility(isLoading: Boolean){
        binding.progressBar.visibility = if(isLoading) View.VISIBLE else View.GONE
    }
}
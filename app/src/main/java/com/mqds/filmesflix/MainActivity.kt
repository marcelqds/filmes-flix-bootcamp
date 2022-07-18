package com.mqds.filmesflix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    }

    private fun initObserver(){
        movieListViewModel.moviesList.observe(this, Observer { list ->
            populateList(list)
        })
    }

    private fun populateList(movies: List<Movie>){
        binding.moviesList.apply {
            hasFixedSize()
            adapter = MovieAdapter(movies)
        }
    }
}
package com.mqds.filmesflix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mqds.filmesflix.databinding.ActivityMainBinding
import com.mqds.filmesflix.model.Movie

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        populateList()
    }

    private fun populateList(){
        binding.moviesList.apply {
            hasFixedSize()
            adapter = MovieAdapter(listOfMoveis)
        }
    }
}
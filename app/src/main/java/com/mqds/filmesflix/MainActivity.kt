package com.mqds.filmesflix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mqds.filmesflix.databinding.MovieItemLayoutBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MovieItemLayoutBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MovieItemLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
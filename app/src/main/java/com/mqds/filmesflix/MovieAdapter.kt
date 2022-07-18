package com.mqds.filmesflix

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mqds.filmesflix.databinding.MovieItemLayoutBinding
import com.mqds.filmesflix.model.Movie


class MovieAdapter: RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private lateinit var movies: MutableList<Movie>

    inner class MovieViewHolder(private val view: MovieItemLayoutBinding): RecyclerView.ViewHolder(view.root){
        fun bind(movie: Movie){
            view.movieTitle.text = movie.title;
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieAdapter.MovieViewHolder {
        val view = MovieItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieAdapter.MovieViewHolder, position: Int) {
        holder.bind(movies.get(position))
    }

    override fun getItemCount() = movies.size

}
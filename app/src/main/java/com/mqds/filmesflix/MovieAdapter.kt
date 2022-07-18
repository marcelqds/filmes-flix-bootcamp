package com.mqds.filmesflix

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.mqds.filmesflix.databinding.MovieItemLayoutBinding
import com.mqds.filmesflix.domain.Movie


class MovieAdapter(private val moviesList: List<Movie>): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    //private lateinit var movies: MutableList<Movie>

    inner class MovieViewHolder(private val view: MovieItemLayoutBinding): RecyclerView.ViewHolder(view.root){
        fun bind(movie: Movie){
            view.apply {
                movieTitle.text = movie.title;
                movieImage.load(movie.image){
                    placeholder(R.drawable.ic_placeholder_24)
                    fallback(R.drawable.ic_placeholder_24)
                }
            }
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
        holder.bind(moviesList.get(position))
    }

    override fun getItemCount() = moviesList.size

}
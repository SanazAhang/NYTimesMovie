package com.example.nytimesmovie.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nytimesmovie.data.model.Model
import com.example.nytimesmovie.databinding.ItemMovieCardBinding

class MovieAdapter : ListAdapter<Model.Movie, MovieAdapter.MovieViewHolder>(DiffCallback()) {

    class MovieViewHolder(private val binding: ItemMovieCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Model.Movie) = with(itemView) {
            binding.movie = movie

            setOnClickListener {
                // TODO: Handle on click
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            ItemMovieCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class DiffCallback : DiffUtil.ItemCallback<Model.Movie>() {
    override fun areItemsTheSame(oldItem: Model.Movie, newItem: Model.Movie): Boolean {
        return oldItem.displayTitle == newItem.displayTitle
    }

    override fun areContentsTheSame(oldItem: Model.Movie, newItem: Model.Movie): Boolean {
        return oldItem == newItem
    }

}
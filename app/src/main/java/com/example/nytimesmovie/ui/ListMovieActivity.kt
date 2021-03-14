package com.example.nytimesmovie.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nytimesmovie.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListMovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: ListMovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movieAdapter = MovieAdapter()
        binding.recyclerViewMovie.layoutManager =
            LinearLayoutManager(this)
        binding.recyclerViewMovie.adapter = movieAdapter

        viewModel.error.observe(this, Observer {

        })

        viewModel.movies.observe(this, Observer {

            movieAdapter.submitList(it)
        })

        viewModel.failure.observe(this, Observer {

        })

//        viewModel.getMovies(dateParameter)

    }

}
package com.example.nytimesmovie.domain.usecase.movieusecase

import com.example.nytimesmovie.data.model.Model
import com.example.nytimesmovie.domain.repository.movie.MovieRepository
import com.example.nytimesmovie.domain.usecase.BaseUseCase
import kotlinx.coroutines.flow.Flow

class MovieGetUseCase
    (private val movieRepository: MovieRepository) :
    BaseUseCase<Unit, Flow<List<Model.Movie>>> {
    override suspend fun execute(input: Unit): Flow<List<Model.Movie>> =
        movieRepository.get()

}


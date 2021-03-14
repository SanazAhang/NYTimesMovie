package com.example.nytimesmovie.domain.usecase.movieusecase

import com.example.nytimesmovie.data.model.Model
import com.example.nytimesmovie.data.model.ResultData
import com.example.nytimesmovie.domain.repository.movie.MovieRepository
import com.example.nytimesmovie.domain.usecase.BaseUseCase

class MovieRefreshUseCase
    (private val movieRepository: MovieRepository) :
    BaseUseCase<Unit, ResultData<List<Model.Movie>>> {

    override suspend fun execute(input: Unit): ResultData<List<Model.Movie>> {
        return movieRepository.refresh()
    }
}
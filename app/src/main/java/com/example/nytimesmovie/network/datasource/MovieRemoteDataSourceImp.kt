package com.example.nytimesmovie.network.datasource

import com.example.nytimesmovie.data.mapper.execute
import com.example.nytimesmovie.data.mapper.mapToModel
import com.example.nytimesmovie.data.model.Model
import com.example.nytimesmovie.data.model.ResultData
import com.example.nytimesmovie.data.model.map
import com.example.nytimesmovie.network.api.MovieAPI

class MovieRemoteDataSourceImp
    (private val movieAPI: MovieAPI) : MovieRemoteDataSource {

    override suspend fun getData(): ResultData<List<Model.Movie>> = execute {
        movieAPI.getMovieList()
    }.map { baseResponse ->
        baseResponse.results.map { movieData ->
            movieData.mapToModel()
        }
    }
}

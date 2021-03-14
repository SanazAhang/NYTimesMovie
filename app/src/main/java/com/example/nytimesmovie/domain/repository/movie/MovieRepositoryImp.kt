package com.example.nytimesmovie.domain.repository.movie


import com.example.nytimesmovie.data.model.Model
import com.example.nytimesmovie.data.model.ResultData
import com.example.nytimesmovie.data.model.onSuccess
import com.example.nytimesmovie.network.datasource.MovieLocalDataSource
import com.example.nytimesmovie.network.datasource.MovieRemoteDataSource
import com.example.nytimesmovie.network.datasource.MovieRemoteDataSourceImp
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

class MovieRepositoryImp(
    private val movieRemoteSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource
) : MovieRepository {

    override suspend fun refresh(): ResultData<List<Model.Movie>> {
        return movieRemoteSource.getData().onSuccess {
            movieLocalDataSource.persist(it)

        }
    }

    override fun get(): Flow<List<Model.Movie>> =
        movieLocalDataSource.fetch()
}
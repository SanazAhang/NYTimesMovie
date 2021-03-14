package com.example.nytimesmovie.network.datasource

import com.example.nytimesmovie.data.mapper.mapToEntity
import com.example.nytimesmovie.data.mapper.mapToModel
import com.example.nytimesmovie.data.model.Model
import com.example.nytimesmovie.database.MovieDao
import com.example.nytimesmovie.database.MovieTable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieLocalDataSourceImp(private val movieDao: MovieDao) : MovieLocalDataSource {


    override fun fetch(): Flow<List<Model.Movie>> {
        return movieDao.select().map {
            it.map { movies ->
                movies.mapToModel()
            }
        }
    }

    override suspend fun persist(movies: List<Model.Movie>) {
        val mutableMovies = mutableListOf<MovieTable.MovieEntity>()
        movies.forEach { movie ->
            mutableMovies.add(movie.mapToEntity())
        }

        movieDao.insertMovies(mutableMovies)
    }
}
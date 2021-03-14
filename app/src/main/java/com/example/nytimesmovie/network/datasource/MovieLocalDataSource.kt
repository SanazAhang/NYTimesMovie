package com.example.nytimesmovie.network.datasource

import com.example.nytimesmovie.data.model.Model
import kotlinx.coroutines.flow.Flow


interface MovieLocalDataSource : LocalDataSource<Model.Movie> {

    fun fetch(): Flow<List<Model.Movie>>

    suspend fun persist(movies: List<Model.Movie>)


}
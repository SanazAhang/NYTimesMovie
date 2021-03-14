package com.example.nytimesmovie.domain.repository.movie

import com.example.nytimesmovie.data.model.Model
import com.example.nytimesmovie.data.model.ResultData
import com.example.nytimesmovie.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

interface MovieRepository :
    Repository<Model.Movie> {

    suspend fun refresh(): ResultData<List<Model.Movie>>

    fun get(): Flow<List<Model.Movie>>
}
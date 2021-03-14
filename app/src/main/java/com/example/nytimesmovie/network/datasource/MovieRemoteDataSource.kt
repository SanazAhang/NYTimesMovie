package com.example.nytimesmovie.network.datasource

import com.example.nytimesmovie.data.model.Model
import com.example.nytimesmovie.data.model.ResultData


interface MovieRemoteDataSource : RemoteDataSource<Model.Movie> {
    suspend fun getData():
            ResultData<List<Model.Movie>>
}
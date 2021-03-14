package com.example.nytimesmovie.network.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {
    @GET("svc/movies/v2/reviews/search.json?query=big&api-key=9NaqETZZADVPCQbRf6tDs8kJEUqH4YCf&opening-date=2018-01-01%3A2020-01-01")
    suspend fun getMovieList(): Response<Dto.BaseResponse<Dto.Movie>>
}
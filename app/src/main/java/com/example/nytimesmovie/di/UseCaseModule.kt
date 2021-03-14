package com.example.nytimesmovie.di

import com.example.nytimesmovie.domain.repository.movie.MovieRepository
import com.example.nytimesmovie.domain.usecase.movieusecase.MovieGetUseCase
import com.example.nytimesmovie.domain.usecase.movieusecase.MovieRefreshUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun refreshMovie(movieRepository: MovieRepository): MovieRefreshUseCase =
        MovieRefreshUseCase(
            movieRepository
        )

    @Singleton
    @Provides
    fun getMovie(movieRepository: MovieRepository): MovieGetUseCase =
        MovieGetUseCase(
            movieRepository
        )


}
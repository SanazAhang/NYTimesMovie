package com.example.nytimesmovie.di

import com.example.nytimesmovie.domain.repository.movie.MovieRepository
import com.example.nytimesmovie.domain.repository.movie.MovieRepositoryImp
import com.example.nytimesmovie.network.datasource.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
abstract class RepositoryModule {


    @Binds
    abstract fun movieRepository(
        movieRepositoryImp: MovieRepositoryImp
    ): MovieRepository

}
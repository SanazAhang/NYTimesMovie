package com.example.nytimesmovie.di

import com.example.nytimesmovie.domain.repository.movie.MovieRepository
import com.example.nytimesmovie.domain.repository.movie.MovieRepositoryImp
import com.example.nytimesmovie.network.datasource.MovieLocalDataSource
import com.example.nytimesmovie.network.datasource.MovieRemoteDataSource
import com.example.nytimesmovie.network.datasource.MovieRemoteDataSourceImp
import com.example.nytimesmovie.network.datasource.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun movieRepository(
        remoteDataSource: MovieRemoteDataSource,
        localDataSource: MovieLocalDataSource
    ):
            MovieRepository =
        MovieRepositoryImp(remoteDataSource, localDataSource)
}
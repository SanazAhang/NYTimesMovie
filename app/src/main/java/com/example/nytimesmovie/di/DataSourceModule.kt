package com.example.nytimesmovie.di

import com.example.nytimesmovie.database.MovieDao
import com.example.nytimesmovie.network.api.MovieAPI
import com.example.nytimesmovie.network.datasource.MovieLocalDataSource
import com.example.nytimesmovie.network.datasource.MovieLocalDataSourceImp
import com.example.nytimesmovie.network.datasource.MovieRemoteDataSource
import com.example.nytimesmovie.network.datasource.MovieRemoteDataSourceImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
class DataSourceModule {

    @Singleton
    @Provides
    fun movieRemoteDataSource(movieAPI: MovieAPI): MovieRemoteDataSource =
        MovieRemoteDataSourceImp(movieAPI)


    @Singleton
    @Provides
    fun movieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource =
        MovieLocalDataSourceImp(movieDao)
}

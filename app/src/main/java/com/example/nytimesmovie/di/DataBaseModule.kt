package com.example.nytimesmovie.di

import android.content.Context
import androidx.room.Room
import com.example.nytimesmovie.database.AppDataBase
import com.example.nytimesmovie.database.MovieDao
import com.example.nytimesmovie.database.MovieTable
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DataBaseModule {
    @Singleton
    @Provides
    fun movieDataBase(@ApplicationContext context: Context): AppDataBase =
        Room.databaseBuilder(
            context,
            AppDataBase::class.java, "database"
        ).build()

    @Singleton
    @Provides
    fun movieDao(appDataBase: AppDataBase): MovieDao =
        appDataBase.movieDao()
}
package com.example.nytimesmovie.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Insert(onConflict = REPLACE)
    suspend fun insertMovies(Movies: List<MovieTable.MovieEntity>)

    @Query("select * from MovieEntity")
    fun select(): Flow<List<MovieTable.MovieEntity>>
}
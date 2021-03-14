package com.example.nytimesmovie.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MovieTable.MovieEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
}
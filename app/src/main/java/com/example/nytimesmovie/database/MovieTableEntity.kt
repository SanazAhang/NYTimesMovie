package com.example.nytimesmovie.database

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

sealed class MovieTable {

    @Entity
    data class MovieEntity(
        @PrimaryKey(autoGenerate = true) val id: Int,
        @ColumnInfo(name = "display_title") val displayTitle: String,
        @ColumnInfo(name = "short_summery") val shortSummery: String,
        @ColumnInfo(name = "publication_date") val publicationDate: String,
        @Embedded
        val article: Article,
        @Embedded
        val imageURL: MultiMedia
    ) : MovieTable()

    data class Article(
        val articleURL: String
    ) : MovieTable()

    data class MultiMedia(
        val imageURL: String
    ) : MovieTable()

}


package com.example.nytimesmovie.data.mapper

import com.example.nytimesmovie.data.model.Model
import com.example.nytimesmovie.data.model.ResultData
import com.example.nytimesmovie.database.MovieTable
import com.example.nytimesmovie.network.api.Dto
import retrofit2.Response

inline fun <T> execute(request: () -> Response<T>): ResultData<T> =
    try {
        val response = request()
        if (response.isSuccessful) {
            ResultData.Success(response.body()!!)
        } else {
            ResultData.Failure(response.message())
        }
    } catch (ex: Exception) {
        ResultData.Error(ex)
    }


fun Dto.Movie.mapToModel() = Model.Movie(
    displayTitle = displayTitle,
    publicationDate = publicationDate,
    shortSummery = shortSummery,
    article = link.mapToModel(),
    multimedia = multimedia.mapToModel()
)

fun Dto.Link.mapToModel() = Model.Article(
    articleURL = articleURL
)

fun Dto.Multimedia.mapToModel() = Model.Multimedia(
    imageURL = imageURL
)

fun Model.Movie.mapToEntity() = MovieTable.MovieEntity(
    id = 0,
    displayTitle = displayTitle,
    publicationDate = publicationDate,
    shortSummery = shortSummery,
    article = article.mapToEntity(),
    imageURL = multimedia.mapToEntity()
)

fun Model.Article.mapToEntity() = MovieTable.Article(
    articleURL = articleURL
)

fun Model.Multimedia.mapToEntity() = MovieTable.MultiMedia(
    imageURL = imageURL
)


fun MovieTable.MovieEntity.mapToModel() = Model.Movie(
    displayTitle = displayTitle,
    publicationDate = publicationDate,
    shortSummery = shortSummery,
    article = article.mapToModel(),
    multimedia = imageURL.mapToModel()
)

fun MovieTable.Article.mapToModel() = Model.Article(
    articleURL = articleURL
)

fun MovieTable.MultiMedia.mapToModel() = Model.Multimedia(
    imageURL = imageURL
)
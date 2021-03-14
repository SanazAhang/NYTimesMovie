package com.example.nytimesmovie.data.model


sealed class Model {

    data class Movie(

        val displayTitle: String,
        val shortSummery: String,
        val publicationDate: String,
        val article: Article,
        val multimedia: Multimedia

    ) : Model()

    data class Article(
        val articleURL: String
    ) : Model()

    data class Multimedia(
        val imageURL: String
    ) : Model()


}
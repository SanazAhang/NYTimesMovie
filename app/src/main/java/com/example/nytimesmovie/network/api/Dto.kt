package com.example.nytimesmovie.network.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


sealed class Dto {

    @JsonClass(generateAdapter = true)
    data class BaseResponse<T>(
        @Json(name = "status") val status: String,
        @Json(name = "results") val results: List<T>
    ) : Dto()

    @JsonClass(generateAdapter = true)
    data class Movie(
        @Json(name = "display_title") val displayTitle: String,
        @Json(name = "summary_short") val shortSummery: String,
        @Json(name = "publication_date") val publicationDate: String,
        @Json(name = "link") val link: Link,
        @Json(name = "multimedia") val multimedia: Multimedia
    ) : Dto()

    @JsonClass(generateAdapter = true)
    data class Link(
        @Json(name = "url") val articleURL: String
    ) : Dto()

    @JsonClass(generateAdapter = true)
    data class Multimedia(
        @Json(name = "src") val imageURL: String
    ) : Dto()
}
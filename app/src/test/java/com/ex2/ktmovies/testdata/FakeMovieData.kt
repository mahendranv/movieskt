package com.ex2.ktmovies.testdata

import com.ex2.ktmovies.domain.model.MovieDetails
import com.ex2.ktmovies.domain.model.MovieLite
import com.ex2.ktmovies.domain.model.MovieResult
import java.util.*

object FakeMovieData {

    val homeItems = listOf(
        MovieLite(id = "1", title = "Movie1", rating = 1.0, imageUrl = null),
        MovieLite(id = "2", title = "Movie2", rating = 0.0, imageUrl = null),
        MovieLite(id = "3", title = "Movie3", rating = 4.0, imageUrl = null),
        MovieLite(id = "4", title = "Movie4", rating = 3.8, imageUrl = null),
        MovieLite(id = "5", title = "Movie5", rating = 2.6, imageUrl = null),
    )

    val movieDetail = MovieDetails(
        id = "1",
        title = "Movie1",
        rating = 1.0,
        summary = "Movie1 description",
        releaseDate = Calendar.getInstance(),
        runTime = 120,
        genre = "Action",
        covers = listOf(),
        images = listOf(),
        related = listOf()
    )

    val searchResults = listOf(
        MovieResult(
            id = "1", title = "Movie1", rating = 1.0, imageUrl = null,
            overview = "",
            genres = "",
            releaseDate = null,
            numberOfRatings = 0,
            runTime = 0
        ),
        MovieResult(
            id = "2", title = "Movie2", rating = 0.0,
            imageUrl = null,
            overview = "",
            genres = "",
            releaseDate = null,
            numberOfRatings = 0,
            runTime = 0
        ),
        MovieResult(
            id = "3", title = "Movie3", rating = 4.0,
            imageUrl = null,
            overview = "",
            genres = "",
            releaseDate = null,
            numberOfRatings = 0,
            runTime = 0
        ),
        MovieResult(
            id = "4", title = "Movie4", rating = 3.8,
            imageUrl = null,
            overview = "",
            genres = "",
            releaseDate = null,
            numberOfRatings = 0,
            runTime = 0
        ),
        MovieResult(
            id = "5", title = "Movie5", rating = 2.6,
            imageUrl = null,
            overview = "",
            genres = "",
            releaseDate = null,
            numberOfRatings = 0,
            runTime = 0
        )
    )
}
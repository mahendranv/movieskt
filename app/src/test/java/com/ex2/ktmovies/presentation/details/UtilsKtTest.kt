package com.ex2.ktmovies.presentation.details

import com.ex2.ktmovies.domain.model.MovieResult
import com.ex2.ktmovies.ratingText
import org.junit.Test

import com.google.common.truth.Truth.assertThat

class UtilsKtTest {

    @Test
    fun `Data error - rating unknown with number of rating`() {
        // Arrange
        val movie = MovieResult(
            id = "",
            title = "",
            rating = 0.0,
            imageUrl = null,
            overview = "",
            genres = "",
            releaseDate = null,
            numberOfRatings = 100,
            runTime = 0
        )
        // Act
        val result = movie.ratingText()

        // Assert
        assertThat(result).isEqualTo("")
    }

    @Test
    fun `Rated count unknown`() {
        // Arrange
        val movie = MovieResult(
            id = "",
            title = "",
            rating = 1.0,
            imageUrl = null,
            overview = "",
            genres = "",
            releaseDate = null,
            numberOfRatings = 0,
            runTime = 0
        )
        // Act
        val result = movie.ratingText()

        // Assert
        assertThat(result).isEqualTo("1.0")
    }

    @Test
    fun `Non rated movie`() {
        // Arrange
        val movie = MovieResult(
            id = "",
            title = "",
            rating = 0.0,
            imageUrl = null,
            overview = "",
            genres = "",
            releaseDate = null,
            numberOfRatings = 0,
            runTime = 0
        )
        // Act
        val result = movie.ratingText()

        // Assert
        assertThat(result).isEqualTo("")
    }

    @Test
    fun `Rating for 1100`() {
        // Arrange
        val movie = MovieResult(
            id = "",
            title = "",
            rating = 1.0,
            imageUrl = null,
            overview = "",
            genres = "",
            releaseDate = null,
            numberOfRatings = 1100,
            runTime = 0
        )
        // Act
        val result = movie.ratingText()

        // Assert
        assertThat(result).isEqualTo("1.0/1k")
    }

    @Test
    fun `Rating equals to 999`() {
        // Arrange
        val movie = MovieResult(
            id = "",
            title = "",
            rating = 1.0,
            imageUrl = null,
            overview = "",
            genres = "",
            releaseDate = null,
            numberOfRatings = 999,
            runTime = 0
        )
        // Act
        val result = movie.ratingText()

        // Assert
        assertThat(result).isEqualTo("1.0/999")
    }
}
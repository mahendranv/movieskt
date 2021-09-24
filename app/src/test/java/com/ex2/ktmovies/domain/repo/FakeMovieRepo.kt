package com.ex2.ktmovies.domain.repo

import com.ex2.ktmovies.common.Either
import com.ex2.ktmovies.common.Failure
import com.ex2.ktmovies.domain.model.MovieDetails
import com.ex2.ktmovies.domain.model.MovieListType
import com.ex2.ktmovies.domain.model.MovieLite
import com.ex2.ktmovies.domain.model.MovieResult
import com.ex2.ktmovies.testdata.FakeMovieData

class FakeMovieRepo(private val failureCase: Boolean = false) : MovieRepo {

    override suspend fun fetchLiteMovies(listType: MovieListType): Either<Failure, List<MovieLite>> {
        return if (failureCase) {
            Either.Left(Failure.UNKNOWN)
        } else {
            Either.Right(FakeMovieData.homeItems)
        }
    }

    override suspend fun fetchMovieDetails(id: String): Either<Failure, MovieDetails> {
        return if (failureCase) {
            Either.Left(Failure.UNKNOWN)
        } else {
            Either.Right(FakeMovieData.movieDetail)
        }
    }

    override suspend fun searchMovies(term: String): Either<Failure, List<MovieResult>> {
        return if (failureCase) {
            Either.Left(Failure.UNKNOWN)
        } else {
            Either.Right(FakeMovieData.searchResults)
        }
    }
}
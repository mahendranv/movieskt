package com.ex2.ktmovies.data.fake

import com.ex2.ktmovies.common.Either
import com.ex2.ktmovies.common.Failure
import com.ex2.ktmovies.data.source.MovieService
import com.ex2.ktmovies.domain.model.MovieDetails
import com.ex2.ktmovies.domain.model.MovieListType
import com.ex2.ktmovies.domain.model.MovieLite
import com.ex2.ktmovies.domain.model.MovieResult
import kotlinx.coroutines.delay
import javax.inject.Inject

const val FAKE_DELAY = 450L

class FakeMovieService @Inject constructor() : MovieService {

    override suspend fun fetchMovies(movieListType: MovieListType): Either<Failure, List<MovieLite>> {
        delay(FAKE_DELAY)
        return Either.Right(FakeData.movieList)
    }

    override suspend fun fetchMovieDetails(id: String): Either<Failure, MovieDetails> {
        delay(FAKE_DELAY)
        return Either.Right(FakeData.movieDetail)
    }

    override suspend fun searchMovie(term: String): Either<Failure, List<MovieResult>> {
        delay(FAKE_DELAY)
        return Either.Right(FakeData.searchResults)
    }
}
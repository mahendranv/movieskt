package com.ex2.ktmovies.data.fake

import com.ex2.ktmovies.common.Either
import com.ex2.ktmovies.common.Failure
import com.ex2.ktmovies.data.source.MovieService
import com.ex2.ktmovies.domain.model.MovieDetails
import com.ex2.ktmovies.domain.model.MovieListType
import com.ex2.ktmovies.domain.model.MovieLite
import com.ex2.ktmovies.domain.model.MovieResult
import javax.inject.Inject

class FakeMovieService @Inject constructor() : MovieService {

    override suspend fun fetchMovies(movieListType: MovieListType): Either<Failure, List<MovieLite>> {
        return Either.Right(FakeData.movieList)
    }

    override suspend fun fetchMovieDetails(id: String): Either<Failure, MovieDetails> {
        return Either.Right(FakeData.movieDetail)
    }

    override suspend fun searchMovie(term: String): Either<Failure, List<MovieResult>> {
        return Either.Right(FakeData.searchResults)
    }
}
package com.ex2.ktmovies.data.tmdb

import com.ex2.ktmovies.common.Either
import com.ex2.ktmovies.common.Failure
import com.ex2.ktmovies.data.source.MovieService
import com.ex2.ktmovies.di.IODispatcher
import com.ex2.ktmovies.domain.model.MovieDetails
import com.ex2.ktmovies.domain.model.MovieListType
import com.ex2.ktmovies.domain.model.MovieLite
import com.ex2.ktmovies.domain.model.MovieResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TMDBServiceV1 @Inject constructor(
    private val facade: HolgerBrandlFacade,

    @IODispatcher
    private val ioDispatcher: CoroutineDispatcher
) : MovieService {

    override suspend fun fetchMovies(movieListType: MovieListType): Either<Failure, List<MovieLite>> = withContext(ioDispatcher) {
        val result: List<MovieLite>? = facade.fetchMovies(movieListType)
        if (result == null) {
            Either.Left(Failure.UNKNOWN)
        } else {
            Either.Right(result)
        }
    }

    override suspend fun fetchMovieDetails(id: String): Either<Failure, MovieDetails> = withContext(ioDispatcher) {
        val movie = facade.fetchMovieDetails(movieId = id)
        return@withContext if (movie == null) {
            Either.Left(Failure.UNKNOWN)
        } else {
            Either.Right(movie)
        }
    }

    override suspend fun searchMovie(term: String): Either<Failure, List<MovieResult>> = withContext(ioDispatcher) {
        val list: List<MovieResult>? = facade.searchMovie(term = term)
        if (list == null) {
            Either.Left(Failure.UNKNOWN)
        } else {
            Either.Right(list)
        }
    }
}
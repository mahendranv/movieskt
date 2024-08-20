package com.ex2.ktmovies.data.repo

import com.ex2.ktmovies.common.Either
import com.ex2.ktmovies.common.Failure
import com.ex2.ktmovies.data.source.MovieService
import com.ex2.ktmovies.domain.model.MovieDetails
import com.ex2.ktmovies.domain.model.MovieListType
import com.ex2.ktmovies.domain.model.MovieLite
import com.ex2.ktmovies.domain.model.MovieResult
import com.ex2.ktmovies.domain.repo.MovieRepo
import javax.inject.Inject
import javax.inject.Named

class MovieRepoImpl @Inject constructor(
    @Named("fake_v1")
//    @Named("tmdb_v1")
    private val movieService: MovieService
) : MovieRepo {

    override suspend fun fetchLiteMovies(listType: MovieListType): Either<Failure, List<MovieLite>> =
        movieService.fetchMovies(listType)

    override suspend fun fetchMovieDetails(id: String): Either<Failure, MovieDetails> =
        movieService.fetchMovieDetails(id)

    override suspend fun searchMovies(term: String): Either<Failure, List<MovieResult>> =
        movieService.searchMovie(term)

}
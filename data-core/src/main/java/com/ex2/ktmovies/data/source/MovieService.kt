package com.ex2.ktmovies.data.source

import com.ex2.ktmovies.common.Either
import com.ex2.ktmovies.common.Failure
import com.ex2.ktmovies.domain.model.MovieDetails
import com.ex2.ktmovies.domain.model.MovieListType
import com.ex2.ktmovies.domain.model.MovieLite
import com.ex2.ktmovies.domain.model.MovieResult

interface MovieService {

    suspend fun fetchMovies(movieListType: MovieListType): Either<Failure, List<MovieLite>>

    suspend fun fetchMovieDetails(id: String): Either<Failure, MovieDetails>

    suspend fun searchMovie(term: String): Either<Failure, List<MovieResult>>
}
package com.ex2.ktmovies.data.source

import com.ex2.ktmovies.common.Either
import com.ex2.ktmovies.common.Failure
import com.ex2.ktmovies.domain.model.MovieListType
import com.ex2.ktmovies.domain.model.MovieLite

interface MovieService {

    suspend fun fetchMovies(movieListType: MovieListType): Either<Failure, List<MovieLite>>

}
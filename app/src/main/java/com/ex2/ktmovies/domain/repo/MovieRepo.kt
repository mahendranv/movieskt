package com.ex2.ktmovies.domain.repo

import com.ex2.ktmovies.common.Either
import com.ex2.ktmovies.common.Failure
import com.ex2.ktmovies.domain.model.MovieListType
import com.ex2.ktmovies.domain.model.MovieLite

interface MovieRepo {

    suspend fun fetchLiteMovies(listType: MovieListType): Either<Failure, List<MovieLite>>
}
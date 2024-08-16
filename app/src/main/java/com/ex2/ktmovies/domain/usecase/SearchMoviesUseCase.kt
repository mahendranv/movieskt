package com.ex2.ktmovies.domain.usecase

import com.ex2.ktmovies.common.Either
import com.ex2.ktmovies.common.Failure
import com.ex2.ktmovies.domain.model.MovieResult
import com.ex2.ktmovies.domain.repo.MovieRepo
import com.ex2.ktmovies.domain.usecase.base.UseCase
import javax.inject.Inject

class SearchMoviesUseCase @Inject constructor(
    private val repo: MovieRepo
) : UseCase<List<MovieResult>, String>() {

    override suspend fun run(params: String): Either<Failure, List<MovieResult>> {
        return repo.searchMovies(params)
    }
}
package com.ex2.ktmovies.domain.usecase

import com.ex2.ktmovies.common.Either
import com.ex2.ktmovies.common.Failure
import com.ex2.ktmovies.domain.model.MovieListType
import com.ex2.ktmovies.domain.model.MovieLite
import com.ex2.ktmovies.domain.repo.MovieRepo
import com.ex2.ktmovies.domain.usecase.base.UseCase
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class GetLiteMoviesUseCase @Inject constructor(
    private val repo: MovieRepo
) : UseCase<List<MovieLite>, GetLiteMoviesUseCase.Params>() {

    override suspend fun run(params: Params): Either<Failure, List<MovieLite>> =
        repo.fetchLiteMovies(params.listType)

    data class Params(val listType: MovieListType)
}
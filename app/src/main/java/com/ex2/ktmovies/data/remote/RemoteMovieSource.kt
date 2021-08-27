package com.ex2.ktmovies.data.remote

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.await
import com.ex2.ktmovies.NowPlayingQuery
import com.ex2.ktmovies.common.Either
import com.ex2.ktmovies.common.Failure
import com.ex2.ktmovies.data.remote.mapper.toDomainModel
import com.ex2.ktmovies.data.source.MovieService
import com.ex2.ktmovies.domain.model.MovieListType
import com.ex2.ktmovies.domain.model.MovieLite
import javax.inject.Inject

class RemoteMovieSource @Inject constructor(
    private val apolloClient: ApolloClient
) : MovieService {

    override suspend fun fetchMovies(movieListType: MovieListType): Either<Failure, List<MovieLite>> {
        return when (movieListType) {
            MovieListType.NOW_PLAYING -> {
                val response = apolloClient.query(NowPlayingQuery()).await()
                if (response.hasErrors()) {
                    Either.Left(Failure.UNKNOWN)
                } else {
                    val list = response.data?.movies?.nowPlaying?.edges?.filterNotNull()?.map {
                        it.fragments.gMovieLite.toDomainModel()
                    }
                    Either.Right(list ?: emptyList())
                }
            }
            MovieListType.TRENDING -> Either.Left(Failure.UNKNOWN)
            MovieListType.TOP_RATED -> Either.Left(Failure.UNKNOWN)
        }
    }
}
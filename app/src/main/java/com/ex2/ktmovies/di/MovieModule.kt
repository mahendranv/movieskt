package com.ex2.ktmovies.di

import com.ex2.ktmovies.data.repo.MovieRepoImpl
import com.ex2.ktmovies.data.source.MovieService
import com.ex2.ktmovies.data.tmdb.TMDBServiceV1
import com.ex2.ktmovies.domain.repo.MovieRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Named

@Module
@InstallIn(ViewModelComponent::class)
abstract class MovieModule {

    @Named("tmdb_v1")
    @Binds
    abstract fun bindTMDBServiceV1(service: TMDBServiceV1): MovieService

    @Binds
    abstract fun bindMovieRepo(repo: MovieRepoImpl): MovieRepo
}
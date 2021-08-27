package com.ex2.ktmovies.di

import com.ex2.ktmovies.data.remote.RemoteMovieSource
import com.ex2.ktmovies.data.repo.MovieRepoImpl
import com.ex2.ktmovies.data.source.MovieService
import com.ex2.ktmovies.domain.repo.MovieRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class MovieModule {

    @Binds
    abstract fun bindMovieService(movieSource: RemoteMovieSource): MovieService

    @Binds
    abstract fun bindMovieRepo(repo: MovieRepoImpl): MovieRepo
}
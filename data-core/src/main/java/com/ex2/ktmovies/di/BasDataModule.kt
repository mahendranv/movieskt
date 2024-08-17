package com.ex2.ktmovies.di

import com.ex2.movies.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
class BasDataModule {

    @Provides
    @Named("tmdb_api_key")
    fun providesImdbApiKey(): String = BuildConfig.TMDB_API_KEY
}
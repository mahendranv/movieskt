package com.ex2.ktmovies.di

import com.apollographql.apollo.ApolloClient
import com.ex2.ktmovies.data.remote.MovieApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun apolloClient(): ApolloClient = MovieApiClient.apolloClient

}
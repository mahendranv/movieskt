package com.ex2.ktmovies.di

import android.content.Context
import com.apollographql.apollo.ApolloClient
import com.ex2.ktmovies.data.remote.MovieApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.io.File
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class CacheDirectory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun apolloClient(@CacheDirectory cacheDirectory: File): ApolloClient {
        return MovieApiClient.createApolloClient(cacheDirectory)
    }

    @CacheDirectory
    @Provides
    fun cacheDirectory(@ApplicationContext context: Context) = context.cacheDir
}
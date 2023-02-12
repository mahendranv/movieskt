package com.ex2.ktmovies.di

import android.content.Context
import coil.ImageLoader
import coil.decode.SvgDecoder
import com.ex2.ktmovies.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import java.io.File
import javax.inject.Named
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class CacheDirectory

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class IODispatcher

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MainDispatcher

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @CacheDirectory
    @Provides
    fun cacheDirectory(@ApplicationContext context: Context): File = context.cacheDir

    @Provides
    fun coilImageLoader(@ApplicationContext context: Context) =
        ImageLoader.Builder(context).components {
            add(SvgDecoder.Factory())
        }.build()

    @Provides
    @Named("tmdb_api_key")
    fun providesImdbApiKey(): String = BuildConfig.TMDB_API_KEY

    @IODispatcher
    @Provides
    fun providesIODispatcher(): CoroutineDispatcher = Dispatchers.IO

    @MainDispatcher
    @Provides
    fun providesMainDispatcher(): CoroutineDispatcher = Dispatchers.Main

}
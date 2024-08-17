package com.ex2.ktmovies.di

import android.content.Context
import coil.ImageLoader
import coil.decode.SvgDecoder
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
class DroidModule {

    @CacheDirectory
    @Provides
    fun cacheDirectory(@ApplicationContext context: Context): File = context.cacheDir

    @Provides
    fun coilImageLoader(@ApplicationContext context: Context) =
        ImageLoader.Builder(context).components {
            add(SvgDecoder.Factory())
        }.build()
}
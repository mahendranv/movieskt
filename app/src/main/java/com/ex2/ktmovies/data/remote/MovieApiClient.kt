package com.ex2.ktmovies.data.remote

import android.util.Log
import com.apollographql.apollo.ApolloClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object MovieApiClient {

    private const val graphUrl = "https://tmdb.apps.quintero.io/"

    private const val TAG = "MovieApiClient"

    private val okHttp = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor {
            Log.i(TAG, it)
        })
        .build()

    // TODO: Custom scalars
    val apolloClient: ApolloClient =
        ApolloClient.builder()
            .serverUrl(graphUrl)
            .okHttpClient(okHttp)
            .build()

}
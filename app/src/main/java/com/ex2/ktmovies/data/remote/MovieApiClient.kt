package com.ex2.ktmovies.data.remote

import android.util.Log
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.CustomTypeAdapter
import com.apollographql.apollo.api.CustomTypeValue
import com.ex2.ktmovies.type.CustomType
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

    // Type adapters
    private val urlTypeAdapter = object : CustomTypeAdapter<String> {

        override fun decode(value: CustomTypeValue<*>): String = value.value.toString()

        override fun encode(value: String): CustomTypeValue<*> =
            CustomTypeValue.GraphQLString(value)
    }

    val apolloClient: ApolloClient =
        ApolloClient.builder()
            .serverUrl(graphUrl)
            .okHttpClient(okHttp)
            .addCustomTypeAdapter(CustomType.URL, urlTypeAdapter)
            .build()

}
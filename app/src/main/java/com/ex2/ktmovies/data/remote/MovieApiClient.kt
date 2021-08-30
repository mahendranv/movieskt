package com.ex2.ktmovies.data.remote

import android.annotation.SuppressLint
import android.util.Log
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.CustomTypeAdapter
import com.apollographql.apollo.api.CustomTypeValue
import com.apollographql.apollo.cache.http.ApolloHttpCache
import com.apollographql.apollo.cache.http.DiskLruHttpCacheStore
import com.ex2.ktmovies.type.CustomType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*

object MovieApiClient {

    private const val graphUrl = "https://tmdb.apps.quintero.io/"

    private const val TAG = "MovieApiClient"

    private val loggingInterceptor = run {
        HttpLoggingInterceptor {
            Log.d(TAG, it)
        }.apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    private val okHttp = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    // Type adapters
    private val urlTypeAdapter = object : CustomTypeAdapter<String> {

        override fun decode(value: CustomTypeValue<*>): String = value.value.toString()

        override fun encode(value: String): CustomTypeValue<*> =
            CustomTypeValue.GraphQLString(value)
    }

    @SuppressLint("SimpleDateFormat")
    private val DATE_FORMAT = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")// ""

    private val dateAdapter = object : CustomTypeAdapter<Calendar> {

        override fun decode(value: CustomTypeValue<*>): Calendar {
            val calendar = Calendar.getInstance()
            calendar.time = DATE_FORMAT.parse(value.value.toString().replace("Z", "+0000"))
            return calendar
        }

        override fun encode(value: Calendar): CustomTypeValue<*> {
            return CustomTypeValue.GraphQLString(DATE_FORMAT.format(value.time))
        }

    }

    fun createApolloClient(cacheDirectory: File): ApolloClient {
        // Apollo cache - http
        // Directory where cached responses will be stored
        val file = File(cacheDirectory, "apolloCache")

        // Size in bytes of the cache
        val size: Long = 1024 * 1024

        // Create the http response cache store
        val cacheStore = DiskLruHttpCacheStore(file, size)
        return ApolloClient.builder()
            .serverUrl(graphUrl)
            .httpCache(ApolloHttpCache(cacheStore))
            .okHttpClient(okHttp)
            .addCustomTypeAdapter(CustomType.URL, urlTypeAdapter)
            .addCustomTypeAdapter(CustomType.DATE, dateAdapter)
            .build()
    }
}
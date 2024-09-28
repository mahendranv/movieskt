package com.ex2.ktmovies.data.tmdb

import android.util.Log
import androidx.annotation.WorkerThread
import com.ex2.ktmovies.domain.model.MovieDetails
import com.ex2.ktmovies.domain.model.MovieListType
import com.ex2.ktmovies.domain.model.MovieLite
import com.ex2.ktmovies.domain.model.MovieResult
import info.movito.themoviedbapi.TmdbApi
import info.movito.themoviedbapi.TmdbMovies
import info.movito.themoviedbapi.TmdbMovies.MovieMethod
import javax.inject.Inject
import javax.inject.Named

class HolgerBrandlFacade @Inject constructor(

    @Named("tmdb_api_key")
    private val apiKey: String
) {
    /**
     * A Lazy property which should be called from non-UI thread. There are n/w calls invoked during
     * initialization. So, keep it lazy and ensure only invoked from methods on worker thread.
     */
    private val api: TmdbMovies by lazy { tmdbApi.movies }

    private val tmdbApi : TmdbApi by lazy { TmdbApi(apiKey) }

    @WorkerThread
    fun fetchMovieDetails(movieId: String): MovieDetails? {
        return try {
            val response = api.getMovie(movieId.toInt(), LANGUAGE, MovieMethod.images, MovieMethod.similar, MovieMethod.credits)
            response.toMovieDetails()
        } catch (e: Exception) {
            Log.d(TAG, "fetchMovieDetails: ", e)
            null
        }
    }

    @WorkerThread
    fun fetchMovies(movieListType: MovieListType): List<MovieLite>? = try {
        // fetch
        val list = when(movieListType) {
            MovieListType.NOW_PLAYING -> api.getNowPlayingMovies(LANGUAGE, 1, REGION)
            MovieListType.TRENDING -> api.getPopularMovies(LANGUAGE, 1)
            MovieListType.TOP_RATED -> api.getTopRatedMovies(LANGUAGE, 1)
        }
        // map
        list.map { it.toMovieLite() }
    } catch (e: Exception) {
        Log.d(TAG, "fetchMovies: ($movieListType)", e)
        null
    }

    @WorkerThread
    fun searchMovie(term: String): List<MovieResult>? {
        val result = tmdbApi.search.searchMovie(term, null, LANGUAGE, false, null)
        return result?.results?.map { it.toMovieResult() }
    }

    companion object {
        private const val TAG = "HolgerBrandlFacade"
        private const val LANGUAGE = "en"
        private const val REGION = "IN"
    }
}
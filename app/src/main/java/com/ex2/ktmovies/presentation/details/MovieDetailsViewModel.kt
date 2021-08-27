package com.ex2.ktmovies.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class MovieDetailsViewModel @AssistedInject constructor(
    @Assisted private val movieId: String,
) : ViewModel() {

    @AssistedFactory
    interface Factory {
        fun create(movieId: String): MovieDetailsViewModel
    }

    companion object {

        fun provideFactory(
            factory: MovieDetailsViewModel.Factory,
            movieId: String
        ): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {

                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return factory.create(movieId) as T
                }
            }
    }
}
package com.ex2.ktmovies.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ex2.ktmovies.domain.model.MovieListType
import com.ex2.ktmovies.domain.model.MovieLite
import com.ex2.ktmovies.domain.usecase.GetLiteMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val liteMoviesUseCase: GetLiteMoviesUseCase
) : ViewModel() {

    private val _movies: MutableStateFlow<List<MovieLite>> = MutableStateFlow(emptyList())
    val movies: StateFlow<List<MovieLite>> = _movies

    fun fetchNowPlaying() {
        if (movies.value.isNotEmpty()) {
            return
        }

        liteMoviesUseCase(
            params = GetLiteMoviesUseCase.Params(listType = MovieListType.NOW_PLAYING),
            viewModelScope,
            onResult = { response ->
                response.fold(
                    {

                    },
                    {
                        _movies.value = it
                        Any()
                    }
                )
            }
        )
    }

    sealed class PageState {


    }
}
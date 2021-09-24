package com.ex2.ktmovies.domain.usecase

import com.ex2.ktmovies.common.Either
import com.ex2.ktmovies.common.Failure
import com.ex2.ktmovies.domain.repo.FakeMovieRepo
import com.ex2.ktmovies.testdata.FakeMovieData
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class GetLiteMoviesUseCaseTest {

    private val testDispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(testDispatcher)

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun `Usecase forwards success result from repo properly`() {
        val SUT: GetMovieDetailsUseCase = GetMovieDetailsUseCase(FakeMovieRepo())
        testScope.launch {
            SUT.invoke("", this) { result ->
                assertThat(result.isRight).isEqualTo(true)
                assertThat(result as Either.Right).isEqualTo(FakeMovieData.movieDetail)
            }
        }
    }

    @Test
    fun `Usecase forwards failure result from repo properly`() {
        val SUT: GetMovieDetailsUseCase = GetMovieDetailsUseCase(FakeMovieRepo(failureCase = true))
        testScope.launch {
            SUT.invoke("", this) { result ->
                assertThat(result.isLeft).isEqualTo(true)
                assertThat(result as Either.Left).isEqualTo(Failure.UNKNOWN)
            }
        }
    }
}
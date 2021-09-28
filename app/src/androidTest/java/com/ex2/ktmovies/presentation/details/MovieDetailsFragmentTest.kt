package com.ex2.ktmovies.presentation.details

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ex2.ktmovies.utils.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class MovieDetailsFragmentTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun testDetailsScreenInitialState() {
        launchFragmentInHiltContainer<MovieDetailsFragment> {

        }
    }
}
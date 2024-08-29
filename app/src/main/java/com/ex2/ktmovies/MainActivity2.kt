package com.ex2.ktmovies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ex2.ktmovies.nav.MoviesAppNavHost
import com.ex2.ktmovies.ui.theme.KtMoviesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KtMoviesTheme {
                MoviesAppNavHost()
            }
        }
    }
}
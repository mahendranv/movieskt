package com.ex2.ktmovies.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ex2.ktmovies.screens.HomeScreen
import com.ex2.ktmovies.screens.details.DetailsScreen
import com.ex2.ktmovies.screens.search.SearchScreen

@Composable
fun MoviesAppNavHost(modifier: Modifier = Modifier) {
    val controller = rememberNavController()
    NavHost(
        navController = controller,
        startDestination = HomeDestination
    ) {
        composable<HomeDestination> {
            HomeScreen()
        }

        composable<SearchDestination> {
            SearchScreen()
        }

        composable<DetailsDestination> { navArgs ->
            DetailsScreen()
        }
    }
}
package com.example.movieapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieapplication.ui.list.screen.MovieListScreen

@Composable
fun MovieAppNavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "movie_list") {
        composable("movie_list") {
            MovieListScreen(navController = navController)
        }
    }
}
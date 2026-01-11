package com.example.movieapplication.ui.list.effect

sealed class MovieListEffect {
    data class NavigateToDetail(val movieId: Int) : MovieListEffect()
    data class ShowError(val message: String) : MovieListEffect()
}
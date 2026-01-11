package com.example.movieapplication.ui.detail

sealed class MovieDetailAction {
    data class LoadMovie(val movieId: Int) : MovieDetailAction()
}
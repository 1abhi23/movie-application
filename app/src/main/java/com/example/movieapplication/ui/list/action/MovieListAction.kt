package com.example.movieapplication.ui.list.action

sealed class MovieListAction {
    object FetchMovies : MovieListAction()
    data class SearchMovies(val query: String) : MovieListAction()
}
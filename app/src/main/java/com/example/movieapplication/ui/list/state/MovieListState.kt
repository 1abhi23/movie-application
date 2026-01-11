package com.example.movieapplication.ui.list.state

import com.example.movieapplication.data.remote.Movie

data class MovieListState(
    val movies: List<Movie> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val lastQuery: String = ""
)
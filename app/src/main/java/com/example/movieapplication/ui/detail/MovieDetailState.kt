package com.example.movieapplication.ui.detail

import com.example.movieapplication.data.remote.Movie

data class MovieDetailState(
    val movie: Movie? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
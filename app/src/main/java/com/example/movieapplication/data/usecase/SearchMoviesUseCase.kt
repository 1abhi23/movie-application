package com.example.movieapplication.data.usecase

import com.example.movieapplication.data.remote.Movie
import com.example.movieapplication.data.repo.MovieRepository
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    @OptIn(FlowPreview::class)
    operator fun invoke(query: String): Flow<List<Movie>> = flow {
        emit(repository.searchMovies(query))
    }.distinctUntilChanged().debounce(300).flatMapLatest { it }
}
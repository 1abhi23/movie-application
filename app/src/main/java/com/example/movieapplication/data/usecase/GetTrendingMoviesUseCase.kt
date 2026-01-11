package com.example.movieapplication.data.usecase

import com.example.movieapplication.data.remote.Movie
import com.example.movieapplication.data.repo.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTrendingMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(): Flow<List<Movie>> {
        return repository.getMovies()
    }
}
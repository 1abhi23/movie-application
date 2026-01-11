package com.example.movieapplication.data.repo

import com.example.movieapplication.data.cache.dao.MovieDao
import com.example.movieapplication.data.cache.mapper.MovieMapper
import com.example.movieapplication.data.remote.Movie
import com.example.movieapplication.data.remote.MovieApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieApiService: MovieApi,
    private val movieDao: MovieDao,
    private val movieMapper: MovieMapper
) {
    suspend fun getMovies(): Flow<List<Movie>> = flow {
        try {
            val networkMovies =
                movieApiService.getTrendingMovies(key = "45d34948a2aa3f184d40f5020e3b42a8").results
            val entities = networkMovies.map { movieMapper.networkToEntity(it) }
            movieDao.insertMovies(entities)
            emit(movieMapper.networksToDomain(networkMovies))
        } catch (e: IOException) {
            movieDao.getMovies().collect { entities ->
                emit(movieMapper.entitiesToDomain(entities))
            }
        } catch (e: HttpException) {
            movieDao.getMovies().collect { entities ->
                emit(movieMapper.entitiesToDomain(entities))
            }
        }
    }

    fun searchMovies(query: String): Flow<List<Movie>> {
        return movieDao.searchMovies("%$query%").map { entities ->
            movieMapper.entitiesToDomain(entities)
        }
    }
}
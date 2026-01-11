package com.example.movieapplication.di

import android.content.Context
import androidx.room.Room
import com.example.movieapplication.data.cache.dao.MovieDao
import com.example.movieapplication.data.cache.db.MovieDatabase
import com.example.movieapplication.data.cache.mapper.MovieMapper
import com.example.movieapplication.data.cache.mapper.MovieMapperImpl
import com.example.movieapplication.data.remote.MovieApi
import com.example.movieapplication.data.repo.MovieRepository
import com.example.movieapplication.data.usecase.GetTrendingMoviesUseCase
import com.example.movieapplication.data.usecase.SearchMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMovieApiService(): MovieApi {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieDatabase(@ApplicationContext context: Context): MovieDatabase {
        return Room.databaseBuilder(
            context,
            MovieDatabase::class.java,
            "movie_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(database: MovieDatabase): MovieDao = database.movieDao()

    @Provides
    @Singleton
    fun provideMovieMapper(): MovieMapper = MovieMapperImpl()

    @Provides
    @Singleton
    fun provideMovieRepository(
        apiService: MovieApi,
        movieDao: MovieDao,
        mapper: MovieMapper
    ): MovieRepository {
        return MovieRepository(apiService, movieDao, mapper)
    }

    @Provides
    @Singleton
    fun provideGetTrendingMoviesUseCase(repository: MovieRepository): GetTrendingMoviesUseCase {
        return GetTrendingMoviesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideSearchMoviesUseCase(repository: MovieRepository): SearchMoviesUseCase {
        return SearchMoviesUseCase(repository)
    }
}
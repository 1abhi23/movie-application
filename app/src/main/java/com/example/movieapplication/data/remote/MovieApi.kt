package com.example.movieapplication.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("trending/movie/week?language=en-US")
    suspend fun getTrendingMovies(@Query("api_key") key: String): NetworkMovieResponse
}
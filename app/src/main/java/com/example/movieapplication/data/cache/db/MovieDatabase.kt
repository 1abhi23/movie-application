package com.example.movieapplication.data.cache.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movieapplication.data.cache.dao.MovieDao
import com.example.movieapplication.data.cache.entity.MovieEntity

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}
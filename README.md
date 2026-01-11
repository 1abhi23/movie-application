# AtlysIMDB – Movie Database App

## Demo Video:

https://github.com/user-attachments/assets/8fe9fb0f-39b2-4063-8c6c-ccf496dc5d5c


AtlysIMDB is a modern Android application built using Kotlin Jetpack Compose, Hilt, Room, Flows, Retrofit, and Kotlin Coroutines.
It allows users to browse trending movies, search for movies, view detailed movie information using The Movie Database (TMDb) API.

The app follows a MVI (Model-View-Intent) architecture and supports offline caching, ensuring smooth user experience even without an internet connection.

# Code Flow Summary

# Fetching Trending Movies
- UI: MovieListScreen triggers LoadMovies intent on first load.
- ViewModel: MovieListViewModel processes FetchMovies action, calling GetTrendingMoviesUseCase.
- Use Case: Invokes MovieRepository.getMovies().
- Repository: Fetches from API, caches in Room, and emits domain models. Falls back to cache on network failure.
- UI: Updates with the movie list or error.

## Searching Movies
- UI: User types in CustomSearchBar, triggering SearchMovies intent after debounce.
- ViewModel: MovieListViewModel processes SearchMovies action, calling SearchMoviesUseCase.
- Use Case: Queries MovieRepository.searchMovies() with debouncing and filtering.
- Repository: Searches Room database and emits results.
- UI: Displays matching movies or empty state.

## Viewing Movie Details
- UI: User clicks a MovieItem, triggering SelectMovie intent.
- ViewModel: MovieListViewModel emits NavigateToDetail effect, navigating to movie_detail/{movieId}.
- UI: MovieDetailScreen loads with MovieDetailViewModel.
- ViewModel: MovieDetailViewModel processes LoadMovie, fetching the movie via GetTrendingMoviesUseCase.
- UI: Displays movie details or error.

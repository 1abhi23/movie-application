package  com.example.movieapplication.ui.list.effect

sealed class MovieListIntent {
    object LoadMovies : MovieListIntent()
    data class SearchMovies(val query: String) : MovieListIntent()
    data class SelectMovie(val movieId: Int) : MovieListIntent()
}
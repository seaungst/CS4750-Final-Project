//Attempt to connect friends watch list to friends page - Camryn

package com.bignerdranch.android.cs4750finalproject
/*
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_watch_list.*

class FriendsWatchListActivity : AppCompatActivity() {
    private lateinit var moviesFWL: RecyclerView
    private lateinit var moviesAdapterFWL: MoviesAdapter
    private lateinit var moviesLayoutMgrFWL: GridLayoutManager

    private var moviesPageFWL = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friends_watch_list)

        moviesFWL = findViewById(R.id.fwl_recyclerView)
        moviesLayoutMgrFWL = GridLayoutManager(
            this, 3)
        wl_recyclerView.layoutManager = moviesLayoutMgrFWL
        moviesAdapterFWL = MoviesAdapter(mutableListOf()) { movie -> showMovieDetails(movie) }
        wl_recyclerView.adapter = moviesAdapterFWL

        getPopularMovies()
    }

    private fun getPopularMovies() {
        MoviesRepository.getPopularMovies(
            moviesPageFWL,
            ::onPopularMoviesFetched,
            ::onError
        )
    }

    private fun onPopularMoviesFetched(movies: List<Movie>) {
        moviesAdapterFWL.appendMovies(movies)
        attachPopularMoviesOnScrollListener()
    }

    private fun attachPopularMoviesOnScrollListener() {
        moviesFWL.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val totalItemCount = moviesLayoutMgrFWL.itemCount
                val visibleItemCount = moviesLayoutMgrFWL.childCount
                val firstVisibleItem = moviesLayoutMgrFWL.findFirstVisibleItemPosition()

                if (firstVisibleItem + visibleItemCount >= totalItemCount / 2) {
                    moviesFWL.removeOnScrollListener(this)
                    moviesPageFWL++
                    getPopularMovies()
                }
            }
        })
    }

    private fun showMovieDetails(movie: Movie) {
        val intent = Intent(this, MovieDetailsActivity::class.java)
        intent.putExtra(MOVIE_BACKDROP, movie.backdropPath)
        intent.putExtra(MOVIE_POSTER, movie.posterPath)
        intent.putExtra(MOVIE_TITLE, movie.title)
        intent.putExtra(MOVIE_RATING, movie.rating)
        intent.putExtra(MOVIE_RELEASE_DATE, movie.releaseDate)
        intent.putExtra(MOVIE_OVERVIEW, movie.overview)
        startActivity(intent)
    }

    private fun onError() {
        Toast.makeText(this, getString(R.string.error_fetch_movies), Toast.LENGTH_SHORT).show()
    }
} */
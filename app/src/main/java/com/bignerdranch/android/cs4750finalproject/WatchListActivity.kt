package com.bignerdranch.android.cs4750finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_watch_list.*

class WatchListActivity : AppCompatActivity() {

    private lateinit var moviesWL: RecyclerView
    private lateinit var moviesAdapterWL: MoviesAdapter
    private lateinit var moviesLayoutMgrWL: GridLayoutManager

    private var moviesPageWL = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_watch_list)

        moviesWL = findViewById(R.id.wl_recyclerView)
        moviesLayoutMgrWL = GridLayoutManager(
            this, 3)
        wl_recyclerView.layoutManager = moviesLayoutMgrWL
        moviesAdapterWL = MoviesAdapter(mutableListOf()) { movie -> showMovieDetails(movie) }
        wl_recyclerView.adapter = moviesAdapterWL

        getPopularMovies()
    }

    private fun getPopularMovies() {
        MoviesRepository.getPopularMovies(
            moviesPageWL,
            ::onPopularMoviesFetched,
            ::onError
        )
    }

    private fun onPopularMoviesFetched(movies: List<Movie>) {
        moviesAdapterWL.appendMovies(movies)
        attachPopularMoviesOnScrollListener()
    }

    private fun attachPopularMoviesOnScrollListener() {
        moviesWL.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val totalItemCount = moviesLayoutMgrWL.itemCount
                val visibleItemCount = moviesLayoutMgrWL.childCount
                val firstVisibleItem = moviesLayoutMgrWL.findFirstVisibleItemPosition()

                if (firstVisibleItem + visibleItemCount >= totalItemCount / 2) {
                    moviesWL.removeOnScrollListener(this)
                    moviesPageWL++
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

}
package com.bignerdranch.android.cs4750finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_movie_search.*

class MovieSearchActivity : AppCompatActivity() {

    private lateinit var moviesMS: RecyclerView
    private lateinit var moviesAdapterMS: MoviesAdapter
    private lateinit var moviesLayoutMgrMS: GridLayoutManager

    private var moviesPageMS = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_search)

        moviesMS = findViewById(R.id.ms_recyclerView)
        moviesLayoutMgrMS = GridLayoutManager(
            this, 3)
        ms_recyclerView.layoutManager = moviesLayoutMgrMS
        moviesAdapterMS = MoviesAdapter(mutableListOf()) { movie -> showMovieDetails(movie) }
        ms_recyclerView.adapter = moviesAdapterMS

        getPopularMovies()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.movie_search_bar, menu)
        return true
    }

    private fun getPopularMovies() {
        MoviesRepository.getPopularMovies(
            moviesPageMS,
            ::onPopularMoviesFetched,
            ::onError
        )
    }

    private fun onPopularMoviesFetched(movies: List<Movie>) {
        moviesAdapterMS.appendMovies(movies)
        attachPopularMoviesOnScrollListener()
    }

    private fun attachPopularMoviesOnScrollListener() {
        moviesMS.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val totalItemCount = moviesLayoutMgrMS.itemCount
                val visibleItemCount = moviesLayoutMgrMS.childCount
                val firstVisibleItem = moviesLayoutMgrMS.findFirstVisibleItemPosition()

                if (firstVisibleItem + visibleItemCount >= totalItemCount / 2) {
                    moviesMS.removeOnScrollListener(this)
                    moviesPageMS++
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


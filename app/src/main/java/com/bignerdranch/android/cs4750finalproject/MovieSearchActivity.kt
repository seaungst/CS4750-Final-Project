// MOVIE DATABASE IMPLEMENTATION - ALLISON (commented out on the bottom of the file)

package com.bignerdranch.android.cs4750finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_movie_search.*

class MovieSearchActivity : AppCompatActivity() {
    //hold the imdb posters by importin database garb
    //include the home button to return
    //include webview onClick
    //testy testy

    private var movieTitlesListMS = mutableListOf<String>()
    private var movieGenresListMS = mutableListOf<String>()
    private var moviePostersListMS = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_search)

        postToListMS()

        sm_recyclerView.layoutManager = LinearLayoutManager(this)
        sm_recyclerView.adapter = RecyclerAdapter(movieTitlesListMS,
            movieGenresListMS, moviePostersListMS)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.movie_search_bar, menu)
        return true
    }

    private fun addToListMS(movie_titleMS: String, movie_genreMS: String, movie_posterMS: Int){
        movieTitlesListMS.add(movie_titleMS)
        movieGenresListMS.add(movie_genreMS)
        moviePostersListMS.add(movie_posterMS)
    }

    private fun postToListMS() {
        for (i in 1..25) {
            addToListMS("Movie Title $i",
                "Movie Genre $i", R.drawable.movie_placeholder)
        }
    }
}

// previously in MainActivity for Allison's separate implementation
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.util.Log
//import android.widget.Toast
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//
//class MainActivity : AppCompatActivity() {
//
//    private lateinit var popularMovies: RecyclerView
//    private lateinit var popularMoviesAdapter: MoviesAdapter
//    private lateinit var popularMoviesLayoutMgr: LinearLayoutManager
//    private lateinit var topRatedMovies: RecyclerView
//    private lateinit var topRatedMoviesAdapter: MoviesAdapter
//    private lateinit var topRatedMoviesLayoutMgr: LinearLayoutManager
//    private lateinit var upcomingMovies: RecyclerView
//    private lateinit var upcomingMoviesAdapter: MoviesAdapter
//    private lateinit var upcomingMoviesLayoutMgr: LinearLayoutManager
//
//    private var popularMoviesPage = 1
//    private var topRatedMoviesPage = 1
//    private var upcomingMoviesPage = 1
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        popularMovies = findViewById(R.id.popular_movies)
//        popularMoviesLayoutMgr = LinearLayoutManager(
//            this,
//            LinearLayoutManager.HORIZONTAL,
//            false
//        )
//        popularMovies.layoutManager = popularMoviesLayoutMgr
//        popularMoviesAdapter = MoviesAdapter(mutableListOf()) { movie -> showMovieDetails(movie) }
//        popularMovies.adapter = popularMoviesAdapter
//
//        topRatedMovies = findViewById(R.id.top_rated_movies)
//        topRatedMoviesLayoutMgr = LinearLayoutManager(
//            this,
//            LinearLayoutManager.HORIZONTAL,
//            false
//        )
//        topRatedMovies.layoutManager = topRatedMoviesLayoutMgr
//        topRatedMoviesAdapter = MoviesAdapter(mutableListOf()) { movie -> showMovieDetails(movie) }
//        topRatedMovies.adapter = topRatedMoviesAdapter
//
//        upcomingMovies = findViewById(R.id.upcoming_movies)
//        upcomingMoviesLayoutMgr = LinearLayoutManager(
//            this,
//            LinearLayoutManager.HORIZONTAL,
//            false
//        )
//        upcomingMovies.layoutManager = upcomingMoviesLayoutMgr
//        upcomingMoviesAdapter = MoviesAdapter(mutableListOf()) { movie -> showMovieDetails(movie) }
//        upcomingMovies.adapter = upcomingMoviesAdapter
//
//        getPopularMovies()
//        getTopRatedMovies()
//        getUpcomingMovies()
//    }
//
//    private fun getPopularMovies() {
//        MoviesRepository.getPopularMovies(
//            popularMoviesPage,
//            ::onPopularMoviesFetched,
//            ::onError
//        )
//    }
//
//    private fun getTopRatedMovies() {
//        MoviesRepository.getTopRatedMovies(
//            topRatedMoviesPage,
//            ::onTopRatedMoviesFetched,
//            ::onError
//        )
//    }
//
//    private fun getUpcomingMovies() {
//        MoviesRepository.getUpcomingMovies(
//            upcomingMoviesPage,
//            ::onUpcomingMoviesFetched,
//            ::onError
//        )
//    }
//
//    private fun onPopularMoviesFetched(movies: List<Movie>) {
//        popularMoviesAdapter.appendMovies(movies)
//        attachPopularMoviesOnScrollListener()
//    }
//
//    private fun attachPopularMoviesOnScrollListener() {
//        popularMovies.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                val totalItemCount = popularMoviesLayoutMgr.itemCount
//                val visibleItemCount = popularMoviesLayoutMgr.childCount
//                val firstVisibleItem = popularMoviesLayoutMgr.findFirstVisibleItemPosition()
//
//                if (firstVisibleItem + visibleItemCount >= totalItemCount / 2) {
//                    popularMovies.removeOnScrollListener(this)
//                    popularMoviesPage++
//                    getPopularMovies()
//                }
//            }
//        })
//    }
//
//    private fun attachTopRatedMoviesOnScrollListener() {
//        topRatedMovies.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                val totalItemCount = topRatedMoviesLayoutMgr.itemCount
//                val visibleItemCount = topRatedMoviesLayoutMgr.childCount
//                val firstVisibleItem = topRatedMoviesLayoutMgr.findFirstVisibleItemPosition()
//
//                if (firstVisibleItem + visibleItemCount >= totalItemCount / 2) {
//                    topRatedMovies.removeOnScrollListener(this)
//                    topRatedMoviesPage++
//                    getTopRatedMovies()
//                }
//            }
//        })
//    }
//
//    private fun onTopRatedMoviesFetched(movies: List<Movie>) {
//        topRatedMoviesAdapter.appendMovies(movies)
//        attachTopRatedMoviesOnScrollListener()
//    }
//
//    private fun attachUpcomingMoviesOnScrollListener() {
//        upcomingMovies.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                val totalItemCount = upcomingMoviesLayoutMgr.itemCount
//                val visibleItemCount = upcomingMoviesLayoutMgr.childCount
//                val firstVisibleItem = upcomingMoviesLayoutMgr.findFirstVisibleItemPosition()
//
//                if (firstVisibleItem + visibleItemCount >= totalItemCount / 2) {
//                    upcomingMovies.removeOnScrollListener(this)
//                    upcomingMoviesPage++
//                    getUpcomingMovies()
//                }
//            }
//        })
//    }
//
//    private fun onUpcomingMoviesFetched(movies: List<Movie>) {
//        upcomingMoviesAdapter.appendMovies(movies)
//        attachUpcomingMoviesOnScrollListener()
//    }
//
//    private fun showMovieDetails(movie: Movie) {
//        val intent = Intent(this, MovieDetailsActivity::class.java)
//        intent.putExtra(MOVIE_BACKDROP, movie.backdropPath)
//        intent.putExtra(MOVIE_POSTER, movie.posterPath)
//        intent.putExtra(MOVIE_TITLE, movie.title)
//        intent.putExtra(MOVIE_RATING, movie.rating)
//        intent.putExtra(MOVIE_RELEASE_DATE, movie.releaseDate)
//        intent.putExtra(MOVIE_OVERVIEW, movie.overview)
//        startActivity(intent)
//    }
//
//    private fun onError() {
//        Toast.makeText(this, getString(R.string.error_fetch_movies), Toast.LENGTH_SHORT).show()
//    }
//
//}

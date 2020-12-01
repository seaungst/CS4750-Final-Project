package com.bignerdranch.android.cs4750finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_watch_list.*

class WatchListActivity : AppCompatActivity() {

    private var movieTitlesList = mutableListOf<String>()
    private var movieGenresList = mutableListOf<String>()
    private var moviePostersList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_watch_list)

        postToList()

        rv_recyclerView.layoutManager = LinearLayoutManager(this)
        rv_recyclerView.adapter = RecyclerAdapter(movieTitlesList,
            movieGenresList, moviePostersList)
    }

    private fun addToList(movie_title: String, movie_genre: String, movie_poster: Int){
        movieTitlesList.add(movie_title)
        movieGenresList.add(movie_genre)
        moviePostersList.add(movie_poster)
    }

    private fun postToList() {
        for (i in 1..25) {
            addToList("Movie Title $i",
                "Movie Genre $i", R.drawable.movie_placeholder)
        }
    }
}
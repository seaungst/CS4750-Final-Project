package com.bignerdranch.android.cs4750finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_watch_list.*

class WatchListActivity : AppCompatActivity() {

    private var movieTitlesListWL = mutableListOf<String>()
    private var movieGenresListWL = mutableListOf<String>()
    private var moviePostersListWL = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_watch_list)

        postToListWL()

        wl_recyclerView.layoutManager = LinearLayoutManager(this)
        wl_recyclerView.adapter = RecyclerAdapter(movieTitlesListWL,
            movieGenresListWL, moviePostersListWL)
    }

    private fun addToListWL(movie_titleWL: String, movie_genreWL: String, movie_posterWL: Int){
        movieTitlesListWL.add(movie_titleWL)
        movieGenresListWL.add(movie_genreWL)
        moviePostersListWL.add(movie_posterWL)
    }

    private fun postToListWL() {
        for (i in 1..25) {
            addToListWL("Movie Title $i",
                "Movie Genre $i", R.drawable.movie_placeholder)
        }
    }
}
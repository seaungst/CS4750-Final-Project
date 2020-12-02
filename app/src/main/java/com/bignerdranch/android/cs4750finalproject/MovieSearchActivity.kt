package com.bignerdranch.android.cs4750finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
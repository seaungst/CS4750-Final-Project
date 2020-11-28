package com.bignerdranch.android.cs4750finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MovieSearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_search)

        val isMovieContainerEmpty = savedInstanceState ==null
        if(isMovieContainerEmpty){
            supportFragmentManager
                .beginTransaction()
                .add(R.id.movieContainer, MovieSearchFragment.newInstance())
                .commit()
        }//determine whether fragment is hosted within container else add it
    }
}
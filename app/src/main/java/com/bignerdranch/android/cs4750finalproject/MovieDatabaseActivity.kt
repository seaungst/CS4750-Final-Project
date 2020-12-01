package com.bignerdranch.android.cs4750finalproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MovieDatabaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_database)
        val isFragmentContainerEmpty = savedInstanceState == null
        if (isFragmentContainerEmpty) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainer,
                    MovieDatabaseFragment.newInstance())
                .commit()
        }
    }
}
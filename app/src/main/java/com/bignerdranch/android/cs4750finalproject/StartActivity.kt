package com.bignerdranch.android.cs4750finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        sign_out.setOnClickListener {
            val signOutIntent = Intent(this, MainActivity::class.java)
            startActivity(signOutIntent)
        }

        watch_list.setOnClickListener {
            val watchListIntent = Intent(this, WatchListActivity::class.java)
            startActivity(watchListIntent)
        }

        search_movies.setOnClickListener {
            val searchMoviesIntent = Intent(this, MovieSearchActivity::class.java)
            startActivity(searchMoviesIntent)
        }
    }

    fun showFriendsPage(view: View) {
        val intent = Intent(this, FriendsActivity::class.java)
        startActivity(intent)
    }

}
package com.bignerdranch.android.cs4750finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)


        // show fragment_friend_list list after pressing movie matcher
        /*movie_matcher.setOnClickListener {
            showFriendsPage()
        }*/

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

        val intent = Intent(this, MovieMatcherActivity::class.java)
        startActivity(intent)

        /*activity_start_layout.visibility = View.GONE
        top_text_start.visibility = View.GONE
        //friends_layout.visibility = View.VISIBLE

        setContentView(R.layout.activity_friends)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)

        if (currentFragment == null) {
            val fragment = FriendsListFragment.newInstance()
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, fragment)
                .commit()
        }*/
    }

}
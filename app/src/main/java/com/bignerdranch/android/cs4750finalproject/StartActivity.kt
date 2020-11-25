package com.bignerdranch.android.cs4750finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_start.*
import kotlinx.android.synthetic.main.watch_list.*

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        // show fragment_friend_list list after pressing movie matcher
        movie_matcher.setOnClickListener {
            showFriendsPage()
        }

        sign_out.setOnClickListener {
            val signOutIntent = Intent(this, MainActivity::class.java)
            startActivity(signOutIntent)
        }

        watch_list.setOnClickListener {
            showWatchList()
        }
    }

    private fun showFriendsPage() {
        activity_start_layout.visibility = View.GONE
        top_text_start.visibility = View.GONE
        //friends_layout.visibility = View.VISIBLE

        setContentView(R.layout.activity_friends)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)

        if (currentFragment == null) {
            val fragment = FriendsListFragment.newInstance()
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, fragment)
                .commit()
        }
    }

    private fun showWatchList() {
        activity_start_layout.visibility = View.GONE
        top_text_start.visibility = View.GONE
        watch_list_layout.visibility = View.VISIBLE
        //start_page_layout.visibility = View.GONE
        //friends_layout.visibility = View.GONE
    }

}
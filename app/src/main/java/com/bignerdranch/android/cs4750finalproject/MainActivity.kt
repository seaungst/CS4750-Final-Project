package com.bignerdranch.android.cs4750finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.sign_up.*
import kotlinx.android.synthetic.main.start_page.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showHomepage()

        //Shows sign up page when sign up button is clicked
        sign_up_homepage.setOnClickListener {
            showSignUp()
        }

        //Shows login page when login button is clicked
        login_homepage.setOnClickListener {
            showLogin()
        }

        //Shows start page after logging in, needs database connection
        /*login_login.setOnClickListener {
            showStartPage()
        }*/

        back_login.setOnClickListener {
            showHomepage()
        }

        //Shows start page after signing up, needs database connection
        sign_up_sign_up.setOnClickListener {
            showStartPage()
        }

        back_sign_up.setOnClickListener {
            showHomepage()
        }

        // show start page after logging in
        login_login.setOnClickListener {
            showStartPage()
        }

        // show friends list after pressing movie matcher
        movie_matcher.setOnClickListener {
            showFriendsPage()
        }

    }

    private fun showSignUp() {
        sign_up_layout.visibility = View.VISIBLE
        login_layout.visibility = View.GONE
        homepage.visibility = View.GONE
        start_page_layout.visibility = View.GONE
    }

    private fun showLogin() {
        sign_up_layout.visibility = View.GONE
        login_layout.visibility = View.VISIBLE
        homepage.visibility = View.GONE
        start_page_layout.visibility = View.GONE
    }

    private fun showHomepage() {
        sign_up_layout.visibility = View.GONE
        login_layout.visibility = View.GONE
        homepage.visibility = View.VISIBLE
        start_page_layout.visibility = View.GONE
    }

    private fun showStartPage() {
        sign_up_layout.visibility = View.GONE
        login_layout.visibility = View.GONE
        homepage.visibility = View.GONE
        start_page_layout.visibility = View.VISIBLE
    }

    private fun showFriendsPage() {
        sign_up_layout.visibility = View.GONE
        login_layout.visibility = View.GONE
        homepage.visibility = View.GONE
        start_page_layout.visibility = View.GONE
//        friends_layout.visibility = View.VISIBLE
    }


}
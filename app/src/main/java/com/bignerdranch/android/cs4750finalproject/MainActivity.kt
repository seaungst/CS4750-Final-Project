package com.bignerdranch.android.cs4750finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.sign_up.*

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

        login_login.setOnClickListener {
            val loginIntent = Intent(this, StartActivity::class.java)
            startActivity(loginIntent);
        }

        sign_up_sign_up.setOnClickListener {
            val signUpIntent = Intent(this, StartActivity::class.java)
            startActivity(signUpIntent);
        }

        back_login.setOnClickListener {
            showHomepage()
        }

        back_sign_up.setOnClickListener {
            showHomepage()
        }

    }

    private fun showSignUp() {
        sign_up_layout.visibility = View.VISIBLE
        login_layout.visibility = View.GONE
        homepage.visibility = View.GONE
        //start_page_layout.visibility = View.GONE
    }

    private fun showLogin() {
        sign_up_layout.visibility = View.GONE
        login_layout.visibility = View.VISIBLE
        homepage.visibility = View.GONE
        //start_page_layout.visibility = View.GONE
    }

    private fun showHomepage() {
        sign_up_layout.visibility = View.GONE
        login_layout.visibility = View.GONE
        homepage.visibility = View.VISIBLE
        //start_page_layout.visibility = View.GONE
    }


}
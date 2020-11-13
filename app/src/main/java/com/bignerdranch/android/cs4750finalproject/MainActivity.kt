package com.bignerdranch.android.cs4750finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.sign_up.*

class MainActivity : AppCompatActivity() {

    lateinit var handler:DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handler = DatabaseHelper(this)

        showHomepage()

        //Shows sign up page when sign up button is clicked
        sign_up_homepage.setOnClickListener {
            showSignUp()
        }

        //Shows login page when login button is clicked
        login_homepage.setOnClickListener {
            showLogin()
        }

        back_login.setOnClickListener {
            showHomepage()
        }

        back_sign_up.setOnClickListener {
            showHomepage()
        }

        //Attempts to login if login button on login page is clicked
        login_login.setOnClickListener {

            //Prints login success message if true
            if (handler.verifyAccount(login_username.text.toString(), login_password.text.toString())) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
            }

            //Prints incorrect attempt message if false
            else {
                Toast.makeText(this, "Username or password is incorrect.", Toast.LENGTH_SHORT).show()
            }
        }

        //Attempts to save user info if save button on sign up page is clicked
        sign_up_sign_up.setOnClickListener {
            handler.insertUserData(username.text.toString(), password.text.toString())
            showHomepage()
        }
    }

    private fun showSignUp() {
        sign_up_layout.visibility = View.VISIBLE
        login_layout.visibility = View.GONE
        homepage.visibility = View.GONE
    }

    private fun showLogin() {
        sign_up_layout.visibility = View.GONE
        login_layout.visibility = View.VISIBLE
        homepage.visibility = View.GONE
    }

    private fun showHomepage() {
        sign_up_layout.visibility = View.GONE
        login_layout.visibility = View.GONE
        homepage.visibility = View.VISIBLE
    }

}
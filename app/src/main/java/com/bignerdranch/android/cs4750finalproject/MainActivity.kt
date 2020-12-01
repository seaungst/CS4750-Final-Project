package com.bignerdranch.android.cs4750finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()

        //Shows sign up page when sign up button is clicked
        sign_up_homepage.setOnClickListener {
            val signUpActivityIntent = Intent(this, SignUpActivity::class.java)
            startActivity(signUpActivityIntent)
        }

        //Shows activity_login page when activity_login button is clicked
        login_homepage.setOnClickListener {
            val loginActivityIntent = Intent(this, LoginActivity::class.java)
            startActivity(loginActivityIntent)
        }
    }
}
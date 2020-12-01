package com.bignerdranch.android.cs4750finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()

        login_login.setOnClickListener {
            doLogin()
        }

        back_login.setOnClickListener {
            val backIntent = Intent(this, MainActivity::class.java)
            startActivity(backIntent)
        }
    }

    private fun doLogin() {
        //If no email inputted
        if(login_email.text.toString().isEmpty()){
            login_email.error = "Please enter an email address."
            login_email.requestFocus()
            return
        }

        //If invalid email inputted
        if(!Patterns.EMAIL_ADDRESS.matcher(login_email.text.toString()).matches()) {
            login_email.error = "Please enter a valid email address."
            login_email.requestFocus()
            return
        }

        //If no password inputted
        if(login_password.text.toString().isEmpty()) {
            login_password.error = "Please enter a password."
            login_password.requestFocus()
            return
        }

        //If invalid password inputted


        auth.signInWithEmailAndPassword(login_email.text.toString(), login_password.text.toString())
            .addOnCompleteListener(this) { task ->

                if (task.isSuccessful) {
                    val user = auth.currentUser
                    updateUILogin(user)
                }

                else {
                    updateUILogin(null)
                }
            }
    }

    private fun updateUILogin(currentUser : FirebaseUser?) {

        if(currentUser != null) {
            val loginIntent = Intent(this, StartActivity::class.java)
            startActivity(loginIntent)
        }

        else {
            Toast.makeText(
                baseContext, "Login failed, please try again.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
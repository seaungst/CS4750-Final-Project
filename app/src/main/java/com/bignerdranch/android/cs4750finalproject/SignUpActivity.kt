package com.bignerdranch.android.cs4750finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        auth = FirebaseAuth.getInstance()
        val db = Firebase.firestore

        sign_up_sign_up.setOnClickListener {
            signUpUser()
        }

        back_sign_up.setOnClickListener {
            val backIntent = Intent(this, MainActivity::class.java)
            startActivity(backIntent)
        }
    }

    private fun signUpUser() {
        //If no email_icon inputted
        if(sign_up_email.text.toString().isEmpty()){
            sign_up_email.error = "Please enter an email address."
            sign_up_email.requestFocus()
            return
        }

        //If invalid email_icon format
        if(!Patterns.EMAIL_ADDRESS.matcher(sign_up_email.text.toString()).matches()) {
            sign_up_email.error = "Please enter a valid email address."
            sign_up_email.requestFocus()
            return
        }

        //If no password inputted
        if(sign_up_password.text.toString().isEmpty()) {
            sign_up_password.error = "Please enter a password."
            sign_up_password.requestFocus()
            return
        }

        if(sign_up_password.text.toString().length < 6) {
            sign_up_password.error = "Password must be at least 6 characters."
            sign_up_password.requestFocus()
            return
        }

        auth.createUserWithEmailAndPassword(sign_up_email.text.toString(), sign_up_password.text.toString())
            .addOnCompleteListener(this) { task ->

                if (task.isSuccessful) {
                    val user = auth.currentUser
                }

                else {
                    updateUISignUp(null)
                }
            }
    }

    private fun updateUsername() {
        val user = auth.currentUser
        //var name = user!!.displayName

        //This section was made to create a username for the user to store in the database
        //Not currently functional
        /*
        val username = sign_up_email.text.toString()
            .substringBefore(delimiter = "@",
                missingDelimiterValue = "Username Not Found")

        val profileUpdates = userProfileChangeRequest {
            name = username
        }

        user!!.updateProfile(profileUpdates)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(
                        baseContext, "Username updated.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
         */
    }

    private fun updateUISignUp(currentUser : FirebaseUser?) {

        if(currentUser != null) {
            val signUpIntent = Intent(this, LoginActivity::class.java)
            startActivity(signUpIntent)
        }

        else {
            Toast.makeText(
                baseContext, "Sign up failed, please try again.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
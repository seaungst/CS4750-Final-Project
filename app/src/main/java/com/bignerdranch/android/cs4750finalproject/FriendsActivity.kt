package com.bignerdranch.android.cs4750finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FriendsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friends)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)

        if (currentFragment == null) {
            val fragment = FriendsListFragment.newInstance()
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, fragment)
                .commit()
        }
    }
}
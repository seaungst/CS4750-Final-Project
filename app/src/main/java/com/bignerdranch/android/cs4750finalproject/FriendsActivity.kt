package com.bignerdranch.android.cs4750finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_friends.*
import kotlinx.android.synthetic.main.activity_watch_list.*

class FriendsActivity : AppCompatActivity() {

    private var friendsTitleList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friends)

        postToList()

        friends_rv_recyclerView.layoutManager = LinearLayoutManager(this)
        friends_rv_recyclerView.adapter = FriendsRecyclerAdapter(friendsTitleList)
    }

    private fun addToList(friends_title: String){
        friendsTitleList.add(friends_title)
    }

    private fun postToList() {
        for (i in 1..25) {
            addToList("Friend # $i")
        }
    }
    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friends)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)

        if (currentFragment == null) {
            val fragment = FriendsListFragment.newInstance()
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, fragment)
                .commit()
        }
    }*/
}
package com.bignerdranch.android.cs4750finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.friend_search_bar, menu)
        return true
    }

    private fun addToList(friends_title: String){
        friendsTitleList.add(friends_title)
    }

    private fun postToList() {
        for (i in 1..25) {
            addToList("Friend # $i")
        }
    }
}
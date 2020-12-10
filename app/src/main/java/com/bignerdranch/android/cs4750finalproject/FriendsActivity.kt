package com.bignerdranch.android.cs4750finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_friends.*
import kotlinx.android.synthetic.main.activity_watch_list.*


//const val FRIEND_TITLE = "friend name"

class FriendsActivity : AppCompatActivity() {

    private var friendsTitleList = mutableListOf<String>()
    private var friendsIconList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friends)

        postToList()

        friends_rv_recyclerView.layoutManager = LinearLayoutManager(this)
        friends_rv_recyclerView.adapter = FriendsRecyclerAdapter(friendsTitleList, friendsIconList)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.friend_search_bar, menu)
        return true
    }

    private fun addToList(friends_title: String, friends_icon: Int){
        friendsTitleList.add(friends_title)
        friendsIconList.add(friends_icon)
    }

    private fun postToList() {
        for (i in 1..25) {
            addToList("Friend $i", R.mipmap.logo_round)
        }
    }

}
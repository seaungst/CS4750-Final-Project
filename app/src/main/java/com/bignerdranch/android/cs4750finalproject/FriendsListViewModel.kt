package com.bignerdranch.android.cs4750finalproject

import androidx.lifecycle.ViewModel

//populating the view model with dummy data

class FriendsListViewModel : ViewModel() {

    val friends = mutableListOf<Friend>()

    init {
        for (i in 0 until 20) {
            val friend = Friend()
            friend.title = "Friend #$i"
            friends += friend
        }
    }
}
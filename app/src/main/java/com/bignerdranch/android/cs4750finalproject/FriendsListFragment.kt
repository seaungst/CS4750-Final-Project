package com.bignerdranch.android.cs4750finalproject

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


//fragment shown when movie_matcher button is pressed

private const val TAG = "FriendsListFragment"

class FriendsListFragment : Fragment() {

    private lateinit var friendsRecyclerView: RecyclerView
    private var adapter: FriendAdapter? = null

    private val friendsListViewModel: FriendsListViewModel by lazy {
        ViewModelProviders.of(this).get(FriendsListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Total fragment_friend_list: ${friendsListViewModel.friends.size}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_friends_list, container, false)
        friendsRecyclerView = view.findViewById(R.id.friends_recycler_view) as RecyclerView
        friendsRecyclerView.layoutManager = LinearLayoutManager(context)

        updateUI()

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.fragment_friend_list, menu)
    }

    private fun updateUI() {
        val friends = friendsListViewModel.friends
        adapter = FriendAdapter(friends)
        friendsRecyclerView.adapter = adapter
    }

    private inner class FriendHolder(view:View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        private lateinit var friend : Friend

        private val titleTextView: TextView = itemView.findViewById(R.id.friend_title)


        init {
            itemView.setOnClickListener(this)
        }

        fun bind(friend: Friend) {
            this.friend = friend
            titleTextView.text = this.friend.title
        }

        override fun onClick(v: View?) {
            Toast.makeText(context, "${friend.title} pressed!", Toast.LENGTH_SHORT).show()
        }
    }

    private inner class FriendAdapter(var friends:List<Friend>) : RecyclerView.Adapter<FriendHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendHolder {
            val view = layoutInflater.inflate(R.layout.list_itme_friend, parent, false)
            return FriendHolder(view)
        }

        override fun getItemCount() = friends.size

        override fun onBindViewHolder(holder: FriendHolder, position: Int) {
            val friend = friends[position]
            holder.bind(friend)
        }
    }

    companion object {
        fun newInstance(): FriendsListFragment {
            return FriendsListFragment()
        }
    }
}
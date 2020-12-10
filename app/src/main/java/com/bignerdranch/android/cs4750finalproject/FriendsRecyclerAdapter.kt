package com.bignerdranch.android.cs4750finalproject

import android.content.Intent
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class FriendsRecyclerAdapter (private var friend_title: List<String>, private var friend_icon: List<Int>)
    : RecyclerView.Adapter<FriendsRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val friendTitle: TextView = itemView.findViewById(R.id.friend_title)
        val friendIcon: ImageView = itemView.findViewById(R.id.friend_icon)

        init {
            itemView.setOnClickListener { v : View ->
                val position: Int = adapterPosition
                Toast.makeText(itemView.context,
                    "Friend ${position + 1} added!",
                    Toast.LENGTH_SHORT).show()

                //Attempt to connect a friends watch list on click - Camryn
                /*val fwlIntent = Intent(FriendsRecyclerAdapter, FriendsWatchListActivity::class.java)
                startActivity(fwlIntent)*/
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.friend_item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return friend_title.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.friendTitle.text = friend_title[position]
        holder.friendIcon.setImageResource(friend_icon[position])
    }

}
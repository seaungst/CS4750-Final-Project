package com.bignerdranch.android.cs4750finalproject

import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class FriendsRecyclerAdapter (private var friend_title: List<String>)
    : RecyclerView.Adapter<FriendsRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val friendTitle: TextView = itemView.findViewById(R.id.friend_title)

        init {
            itemView.setOnClickListener { v : View ->
                val position: Int = adapterPosition
                Toast.makeText(itemView.context,
                    "Friend #${position + 1} pressed!",
                    Toast.LENGTH_SHORT).show()
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
    }

}
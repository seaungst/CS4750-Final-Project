package com.bignerdranch.android.cs4750finalproject

import android.view.*
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter (private var movie_titles: List<String>,
                       private var movie_genres: List<String>,
                       private var movie_posters: List<Int>)
    : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val movieTitle: TextView = itemView.findViewById(R.id.movie_title)
        val movieGenre: TextView = itemView.findViewById(R.id.movie_genre)
        val moviePoster: ImageView = itemView.findViewById(R.id.movie_poster)

        init {
            itemView.setOnClickListener { v : View ->
                val position: Int = adapterPosition
                Toast.makeText(itemView.context,
                    "Movie #${position + 1} pressed!",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return movie_titles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.movieTitle.text = movie_titles[position]
        holder.movieGenre.text = movie_genres[position]
        holder.moviePoster.setImageResource(movie_posters[position])
    }

}
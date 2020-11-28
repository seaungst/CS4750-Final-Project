package com.bignerdranch.android.cs4750finalproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MovieSearchFragment: Fragment() {
    private lateinit var movieRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val moview = inflater.inflate(R.layout.fragment_movie, container, false)

        movieRecyclerView = moview.findViewById(R.id.movie_recycler_view)
        movieRecyclerView.layoutManager  = GridLayoutManager(context,4)
        //set viewmodel to gridlayout of size 4 per line from the movierecyclerView
        return moview
    }

    companion object{
        fun newInstance() = MovieSearchFragment()
    }
}
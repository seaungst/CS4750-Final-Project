package com.bignerdranch.android.cs4750finalproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class MovieViewModel : ViewModel() {
    val movieItemLiveData: LiveData<List<MovieItem>>
    init {
        movieItemLiveData = MovieFetcher().fetchMovies()
    }
}

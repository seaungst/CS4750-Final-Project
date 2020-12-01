package com.bignerdranch.android.cs4750finalproject

import com.google.gson.annotations.SerializedName

class MovieResponse {
    @SerializedName("movie poster")
    lateinit var movieItem: List<MovieItem>
}
package com.bignerdranch.android.cs4750finalproject

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String = "Bb5a820a7095557ca86bce0711aaddf7",
        @Query("page") page: Int
    ): Call<GetMoviesResponse>
}
package com.bignerdranch.android.cs4750finalproject

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import api.MovieDatabaseApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

private const val TAG = "MovieFetchr"
class MovieFetcher {
    private val movieApi: MovieDatabaseApi
    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://www.imdb.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        movieApi = retrofit.create(MovieDatabaseApi::class.java)
    }

    fun fetchMovies(): LiveData<List<MovieItem>> {
        val responseLiveData: MutableLiveData<List<MovieItem>> =
            MutableLiveData()
        val movieRequest: Call<ImbdResponse> = movieApi.fetchMovies()
        movieRequest.enqueue(object : Callback<ImbdResponse> {
            override fun onFailure(call: Call<ImbdResponse>, t: Throwable) {
                Log.e(TAG, "Failed to fetch photos", t)
            }

            override fun onResponse(
                call: Call<ImbdResponse>,
                response: Response<ImbdResponse>
            ) {
                Log.d(TAG, "Response received")
                val ImbdResponse: ImbdResponse? = response.body()
                val photoResponse: MovieResponse? =
                    ImbdResponse?.movie
                var movieItems: List<MovieItem> =
                    photoResponse?.movieItem
                        ?: mutableListOf()
                movieItems = movieItems.filterNot {
                    it.url.isBlank()
                }
                responseLiveData.value = movieItems
            }
        })
        return responseLiveData
    }
}
package com.bignerdranch.android.cs4750finalproject.Remote

import com.bignerdranch.android.cs4750finalproject.Model.APIResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface IMyAPI {
    @FormUrlEncoded
    @POST("sign_up.php")
    fun signUp(@Field("username") username:String, @Field("password") password:String): Call<APIResponse>

    @FormUrlEncoded
    @POST("login.php")
    fun login(@Field("username") username:String, @Field("password") password:String): Call<APIResponse>
}
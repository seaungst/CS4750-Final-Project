package com.bignerdranch.android.cs4750finalproject

import android.net.Uri
import com.google.gson.annotations.SerializedName

data class MovieItem(
    /**
    var title: String = "",
    var id: String = "",
    @SerializedName("url_s") var url: String = ""
    **/
    var title: String = "",
    var id: String = "",
    @SerializedName("url_s") var url: String = "",
    @SerializedName("owner") var owner: String = ""
) {
    val photoPageUri: Uri
        get() {
            //return Uri.parse("https://www.flickr.com/photos/")
            return Uri.parse("https://www.imdb.com/search/")
            //.buildUpon()
            //.appendPath(owner)
            //.appendPath(id)
            //.build()
        }
}

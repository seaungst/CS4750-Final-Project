package api

import com.bignerdranch.android.cs4750finalproject.ImbdResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieDatabaseApi {
    @GET(
        //"services/rest/?method=flickr.interestingness.getList" +
                //"https://imdb8.p.rapidapi.com/title/auto-complete?q=game%20of%20thr" +
          "title/get-details" +
                "&api_key=be39e2e48cmsh3e133045283bbd8p1ab840jsn19de99fbd2af" //+
               // "&format=json" +
               // "&nojsoncallback=1" +
               // "&extras=url_s"
    )
    fun fetchMovies(): Call<ImbdResponse>
}
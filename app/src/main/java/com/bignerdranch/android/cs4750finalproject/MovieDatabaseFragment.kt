package com.bignerdranch.android.cs4750finalproject

import android.graphics.Movie
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

private const val TAG = "MovieDatabaseFragment"

class MovieDatabaseFragment : Fragment() {
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var movieRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        movieViewModel =
            ViewModelProviders.of(this).get(MovieViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_movie_database,
            container, false)
        movieRecyclerView = view.findViewById(R.id.movie_recycler_view)
        movieRecyclerView.layoutManager = GridLayoutManager(context, 3)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        movieViewModel.movieItemLiveData.observe(
            viewLifecycleOwner,
            Observer { movieItems ->
                movieRecyclerView.adapter = MovieAdapter(movieItems)
            })
    }

    /**
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        movieViewModel.movieItemLiveData.observe(
           viewLifecycleOwner,
          Observer { movieItems ->
             movieRecyclerView.adapter = MovieAdapter(movieItems)
         })
    }
     **/
    private class MovieHolder(itemTextView: TextView)
        : RecyclerView.ViewHolder(itemTextView) {
        val bindTitle: (CharSequence) -> Unit = itemTextView::setText
    }

    private class MovieAdapter(private val galleryItems:
                               List<MovieItem>)
        : RecyclerView.Adapter<MovieHolder>() {
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): MovieHolder {
            val textView = TextView(parent.context)
            return MovieHolder(textView)
        }
        override fun getItemCount(): Int = galleryItems.size
        override fun onBindViewHolder(holder: MovieHolder, position:
        Int) {
            val galleryItem = galleryItems[position]
            holder.bindTitle(galleryItem.title)
        }
    }

    companion object {
        fun newInstance() = MovieDatabaseFragment()
    }
}

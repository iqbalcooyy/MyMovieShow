package com.iqbalproject.mymovieshow.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.ArrayAdapter
import com.google.gson.Gson
import com.iqbalproject.mymovieshow.R
import com.iqbalproject.mymovieshow.adapter.MovieAdapter
import com.iqbalproject.mymovieshow.model.Genres
import com.iqbalproject.mymovieshow.model.Movies
import com.iqbalproject.mymovieshow.presenter.GenresPresenter
import com.iqbalproject.mymovieshow.presenter.GenresView
import com.iqbalproject.mymovieshow.presenter.MoviesPresenter
import com.iqbalproject.mymovieshow.presenter.MoviesView
import com.iqbalproject.mymovieshow.utils.ApiRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), GenresView, MoviesView {

    private lateinit var spinnerAdapter: ArrayAdapter<String>
    private var genre: MutableList<String> = mutableListOf()
    private lateinit var adapterMovie: MovieAdapter
    private lateinit var presenterGenre: GenresPresenter
    private lateinit var presenterMovie: MoviesPresenter
    private var genres: MutableList<Genres> = mutableListOf()
    private var movies: MutableList<Movies> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapterMovie = MovieAdapter(this, movies)
        gvMovies.adapter = adapterMovie

        val request = ApiRepository()
        val gson = Gson()

        presenterGenre = GenresPresenter(this, request, gson)
        presenterGenre.getGenreList()

        presenterMovie = MoviesPresenter(this, request, gson)
        presenterMovie.getMovieList()

        spinnerAdapter = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_dropdown_item, genre)
        spinnerGenre.adapter = spinnerAdapter
    }

    override fun showGenreList(data: List<Genres>) {
        genres.clear()
        genres.addAll(data)
        Log.d("GENRE_LIST", data.toString())

        for (i in data.indices){
            genre.add(i, data.get(i).genreName.toString())
        }

        spinnerAdapter.notifyDataSetChanged()
    }

    override fun showMovieList(data: List<Movies>) {
        movies.clear()
        movies.addAll(data)
        adapterMovie.notifyDataSetChanged()
        Log.d("MOVIE_LIST", data.toString())
    }
}

package com.iqbalproject.mymovieshow.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.AdapterView
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
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity(), GenresView, MoviesView {

    private lateinit var spinnerAdapter: ArrayAdapter<String>
    private var genre: MutableList<String> = mutableListOf()
    private lateinit var adapterMovie: MovieAdapter
    private lateinit var presenterGenre: GenresPresenter
    private lateinit var presenterMovie: MoviesPresenter
    private var genres: MutableList<Genres> = mutableListOf()
    private var movies: MutableList<Movies> = mutableListOf()
    private lateinit var genreId: String

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

        spinnerAdapter = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_dropdown_item, genre)
        spinnerGenre.adapter = spinnerAdapter

        spinnerGenre.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val genId = spinnerGenre.selectedItem.toString().split("_")
                genreId = genId.get(1)
                presenterMovie.getMovieList(genreId)
                Log.d("GENRE_ID", genreId)
            }

        }

        gvMovies.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                startActivity<DetailActivity>()
            }

        }
    }

    override fun showGenreList(data: List<Genres>) {
        genres.clear()
        genres.addAll(data)
        Log.d("GENRE_LIST", data.toString())

        for (i in data.indices) {
            genre.add(i, data.get(i).genreName.toString() + "_" + data.get(i).genreId.toString())
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

package com.iqbalproject.mymovieshow.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerSupportFragment
import com.google.gson.Gson
import com.iqbalproject.mymovieshow.BuildConfig
import com.iqbalproject.mymovieshow.R
import com.iqbalproject.mymovieshow.model.TrailerMovie
import com.iqbalproject.mymovieshow.presenter.TrailerPresenter
import com.iqbalproject.mymovieshow.presenter.TrailerView
import com.iqbalproject.mymovieshow.utils.ApiRepository
import kotlinx.android.synthetic.main.fragment_overview.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class OverviewFragment : Fragment(), YouTubePlayer.OnInitializedListener, TrailerView {

    private lateinit var overview: String
    private lateinit var movieId: String
    private var trailerMovie: MutableList<TrailerMovie> = mutableListOf()
    private lateinit var trailerPresenter: TrailerPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_overview, container, false)

        val ytPlayerFragment: YouTubePlayerSupportFragment = YouTubePlayerSupportFragment.newInstance()
        val fragmentTrx: FragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTrx.add(R.id.ytPlayer, ytPlayerFragment).commit()

        ytPlayerFragment.initialize(BuildConfig.GOOGLE_API_KEY, this)

        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        overview = arguments?.getString("overview").toString()
        movieId = arguments?.getString("movieId").toString()

        val request = ApiRepository()
        val gson = Gson()

        trailerPresenter = TrailerPresenter(this, request, gson)
        trailerPresenter.getDetailMovieList(movieId)

        tvOverview.text = overview
    }

    override fun showDetailsMovie(data: List<TrailerMovie>) {
        trailerMovie.clear()
        trailerMovie.addAll(data)
    }

    override fun onInitializationSuccess(
        provider: YouTubePlayer.Provider?,
        player: YouTubePlayer?,
        wasRestored: Boolean
    ) {
        if (!wasRestored) {
            player?.cueVideo(trailerMovie.last().videoKey)
        }
    }

    override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
    }

}

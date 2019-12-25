package com.iqbalproject.mymovieshow.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson

import com.iqbalproject.mymovieshow.R
import com.iqbalproject.mymovieshow.adapter.ReviewsAdapter
import com.iqbalproject.mymovieshow.model.Review
import com.iqbalproject.mymovieshow.presenter.ReviewsPresenter
import com.iqbalproject.mymovieshow.presenter.ReviewsView
import com.iqbalproject.mymovieshow.utils.ApiRepository
import kotlinx.android.synthetic.main.fragment_review.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ReviewFragment : Fragment(), ReviewsView {

    private lateinit var adapter: ReviewsAdapter
    private lateinit var presenter: ReviewsPresenter
    private var reviews: MutableList<Review> = mutableListOf()
    private lateinit var movieId: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_review, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        movieId = arguments?.getString("movieId").toString()
        adapter = ReviewsAdapter(this.requireContext(), reviews)
        rvReviewList.adapter = adapter

        val request = ApiRepository()
        val gson = Gson()
        presenter = ReviewsPresenter(this,request, gson)
        presenter.getReviewsMovie(this.requireContext(), movieId)
    }

    override fun showReviewList(data: List<Review>) {
        reviews.clear()
        reviews.addAll(data)
        adapter.notifyDataSetChanged()
    }
}

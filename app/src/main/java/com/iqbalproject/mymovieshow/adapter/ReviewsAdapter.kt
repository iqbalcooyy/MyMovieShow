package com.iqbalproject.mymovieshow.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iqbalproject.mymovieshow.R
import com.iqbalproject.mymovieshow.model.Review
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.reviews.*

class ReviewsAdapter(private val context: Context, private val reviews: List<Review>): RecyclerView.Adapter<ReviewViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        return ReviewViewHolder(LayoutInflater.from(context).inflate(R.layout.reviews, parent, false))
    }

    override fun getItemCount(): Int {
        return reviews.size
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        return holder.bindItems(reviews.get(position))
    }
}

class ReviewViewHolder(override val containerView: View): RecyclerView.ViewHolder(containerView), LayoutContainer {
    fun bindItems(reviews: Review){
        tvAuthor.text = reviews.author
        tvComment.text = reviews.comment
    }
}
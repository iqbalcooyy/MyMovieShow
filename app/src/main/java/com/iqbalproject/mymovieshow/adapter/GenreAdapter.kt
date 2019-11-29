package com.iqbalproject.mymovieshow.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iqbalproject.mymovieshow.R
import com.iqbalproject.mymovieshow.model.Genres
import kotlinx.android.synthetic.main.genre.view.*

class GenreAdapter(private val genres: List<Genres>, private val listener: (Genres) -> Unit) :
RecyclerView.Adapter<GenreViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        return GenreViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.genre, parent, false))
    }

    override fun getItemCount(): Int {
        return genres.size
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        holder.bindItem(genres[position], listener)
    }
}

class GenreViewHolder(view: View): RecyclerView.ViewHolder(view) {
    fun bindItem(genres: Genres, listener: (Genres) -> Unit){
        itemView.tvGenreName.text = genres.genreName
    }
}

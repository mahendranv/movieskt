package com.ex2.ktmovies.presentation.details;

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ex2.ktmovies.common.extensions.loadImage
import com.ex2.ktmovies.databinding.LiRelatedMovieBinding
import com.ex2.ktmovies.domain.model.MovieLite
import com.ex2.ktmovies.platform.DisplayHelper

typealias MovieLiteClickListener = (MovieLite) -> Unit

class RelatedMoviesAdapter : RecyclerView.Adapter<RelatedMoviesAdapter.MovieViewHolder>() {

    private var items = emptyList<MovieLite>()

    private var itemClickListener: MovieLiteClickListener? = null

    fun setItems(_items: List<MovieLite>) {
        items = _items
    }

    fun setOnItemClickListener(_listener: MovieLiteClickListener) {
        itemClickListener = _listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LiRelatedMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount() = items.size

    inner class MovieViewHolder(val binding: LiRelatedMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        var item: MovieLite? = null

        init {
            itemView.setOnClickListener {
                item?.let {
                    itemClickListener?.invoke(it)
                }
            }
        }

        fun bind(item: MovieLite) {
            this.item = item
            with(binding) {
                movieThumb.loadImage(item.imageUrl, cornerRadius = DisplayHelper.DP_8)
            }
        }
    }
}
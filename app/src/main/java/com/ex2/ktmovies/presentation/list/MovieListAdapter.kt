package com.ex2.ktmovies.presentation.list;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ex2.ktmovies.common.extensions.loadImage
import com.ex2.ktmovies.databinding.LiHomeThumbBinding
import com.ex2.ktmovies.domain.model.MovieLite
import com.ex2.ktmovies.platform.DisplayHelper

typealias MovieLiteClickListener = (View, MovieLite) -> Unit

class MovieListAdapter : RecyclerView.Adapter<MovieListAdapter.MovieViewHolder>() {

    private var items = emptyList<MovieLite>()

    private var itemClickListener: MovieLiteClickListener? = null

    fun setItems(_items: List<MovieLite>) {
        items = _items
    }

    fun setOnItemClickListener(_listener: MovieLiteClickListener) {
        itemClickListener = _listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = LiHomeThumbBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount() = items.size

    inner class MovieViewHolder(private val binding: LiHomeThumbBinding) :
        RecyclerView.ViewHolder(binding.root) {

        var item: MovieLite? = null

        init {
            itemView.setOnClickListener {
                item?.let {
                    itemClickListener?.invoke(itemView, it)
                }
            }
        }

        fun bind(item: MovieLite) {
            this.item = item

            with(binding) {
                // Unique transition name for each time to support exit transition from
                // Movie details screen
                root.transitionName =
                    root.context.getString(com.ex2.ktmovies.R.string.transition_to_details, item.id)
                titleLabel.text = item.title
                movieThumb.loadImage(
                    url = item.imageUrl,
                    cornerRadius = DisplayHelper.DP_8
                )
                ratingLabel.text = if (item.rating > 0.0) String.format(
                    "%.1f",
                    item.rating
                ) else ratingLabel.context.getString(com.ex2.ktmovies.R.string.new_entry)
            }
        }
    }
}
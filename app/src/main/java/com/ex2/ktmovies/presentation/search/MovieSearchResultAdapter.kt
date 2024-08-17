package com.ex2.ktmovies.presentation.search;

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ex2.ktmovies.common.extensions.loadImage
import com.ex2.ktmovies.common.extensions.showIf
import com.ex2.ktmovies.databinding.ItemMovieSearchResultBinding
import com.ex2.ktmovies.domain.model.MovieResult
import com.ex2.ktmovies.prepareMeta
import com.ex2.ktmovies.ratingText

typealias MovieLiteClickListener = (ItemMovieSearchResultBinding, MovieResult) -> Unit

class MovieSearchResultAdapter : RecyclerView.Adapter<MovieSearchResultAdapter.MovieViewHolder>() {

    private var items = emptyList<MovieResult>()

    private var itemClickListener: MovieLiteClickListener? = null

    fun setItems(_items: List<MovieResult>) {
        items = _items
    }

    fun setOnItemClickListener(_listener: MovieLiteClickListener) {
        itemClickListener = _listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding =
            ItemMovieSearchResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = items[position]
        //TODO Fill in your logic for binding the view.
        holder.bind(item)
    }

    override fun getItemCount() = items.size

    inner class MovieViewHolder(private val binding: ItemMovieSearchResultBinding) :
        RecyclerView.ViewHolder(binding.root) {

        var item: MovieResult? = null

        init {
            itemView.setOnClickListener {
                item?.let {
                    itemClickListener?.invoke(binding, it)
                }
            }
        }

        @SuppressLint("SetTextI18n")
        fun bind(item: MovieResult) {
            this.item = item

            with(binding) {
                // Unique transition name for each line item
                movieThumb.transitionName = root.context.getString(com.ex2.ktmovies.R.string.transition_to_details, item.id)

                titleLabel.text = item.title
                movieThumb.loadImage(item.imageUrl)
                ratingLabel.text = item.ratingText()
                metaLabel.text = item.prepareMeta()
                descriptionLabel.text = item.overview
                ratingLabel.showIf(item.rating > 0.0)
            }
        }
    }
}
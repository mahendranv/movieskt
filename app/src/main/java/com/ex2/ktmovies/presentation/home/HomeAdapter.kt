package com.ex2.ktmovies.presentation.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView
import com.ex2.ktmovies.R
import com.ex2.ktmovies.databinding.LiHomeThumbBinding
import com.ex2.ktmovies.domain.model.MovieLite
import kotlin.collections.List

typealias MovieLiteClickListener = (MovieLite) -> Unit

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.MovieViewHolder>() {

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
                    itemClickListener?.invoke(it)
                }
            }
        }

        fun bind(item: MovieLite) {
            this.item = item

            with(binding) {
                titleLabel.text = item.title
            }
        }
    }
}
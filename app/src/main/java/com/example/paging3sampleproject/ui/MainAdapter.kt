package com.example.paging3sampleproject.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.paging3sampleproject.R
import com.example.paging3sampleproject.databinding.ListItemBinding
import com.example.paging3sampleproject.model.Data

class MainAdapter : PagingDataAdapter<Data, MainViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return DataBindingUtil.inflate<ListItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.list_item,
            parent,
            false
        ).let { MainViewHolder(it) }
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<Data>() {
            override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
                return oldItem == newItem
            }
        }
    }
}

class MainViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: Data) {
        binding.data = data
    }
}
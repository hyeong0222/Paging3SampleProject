package com.example.paging3sampleproject.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.paging3sampleproject.databinding.ItemLoadingBinding

class HeaderFooterAdapter : LoadStateAdapter<HeaderFooterViewHolder>() {
    override fun onBindViewHolder(holder: HeaderFooterViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): HeaderFooterViewHolder {
        val binding = ItemLoadingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HeaderFooterViewHolder(binding)
    }
}

class HeaderFooterViewHolder(private val binding: ItemLoadingBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(loadState: LoadState) {
        binding.itemLoading.isVisible = loadState is LoadState.Loading
    }
}
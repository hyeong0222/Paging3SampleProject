package com.example.paging3sampleproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.paging3sampleproject.databinding.ActivityMainBinding
import com.example.paging3sampleproject.ui.HeaderFooterAdapter
import com.example.paging3sampleproject.ui.MainAdapter
import com.example.paging3sampleproject.viewmodel.MainViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val adapter by lazy { MainAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setupAdapter()
        setupViewModel()
        setupListener()
    }

    private fun setupAdapter() {
        val concatAdapter = adapter.withLoadStateFooter(footer = HeaderFooterAdapter())
        binding.recyclerview.adapter = concatAdapter
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(MainViewModel::class.java)
    }

    private fun setupListener() {
        lifecycleScope.launch {
            viewModel.listData.collect {
                adapter.submitData(it)
            }
        }
    }
}
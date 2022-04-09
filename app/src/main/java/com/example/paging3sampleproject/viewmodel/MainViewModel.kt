package com.example.paging3sampleproject.viewmodel

import androidx.lifecycle.*
import androidx.paging.cachedIn
import com.example.paging3sampleproject.repository.MainRepository

class MainViewModel : ViewModel() {
    private val repository = MainRepository()

    val listData = repository.getResponseItemsByPaging().cachedIn(viewModelScope)
}
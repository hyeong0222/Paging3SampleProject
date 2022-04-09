package com.example.paging3sampleproject.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.paging3sampleproject.model.Data
import kotlinx.coroutines.flow.Flow

class MainRepository {
    fun getResponseItemsByPaging(): Flow<PagingData<Data>> {
        return Pager(PagingConfig(pageSize = 6)) { PostDataSource() }.flow
    }
}
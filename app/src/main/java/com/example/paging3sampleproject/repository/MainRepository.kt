package com.example.paging3sampleproject.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.paging3sampleproject.model.User
import kotlinx.coroutines.flow.Flow

class MainRepository {
    fun getResponseItemsByPaging(): Flow<PagingData<User>> {
        return Pager(PagingConfig(pageSize = 10)) { PostDataSource() }.flow
    }
}
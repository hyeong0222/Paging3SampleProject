package com.example.paging3sampleproject.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paging3sampleproject.model.Data
import com.example.paging3sampleproject.network.ApiService
import com.example.paging3sampleproject.network.RetrofitClient

class PostDataSource() : PagingSource<Int, Data>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        try {
            val currentLoadingPageKey = params.key ?: 1
            val apiService = RetrofitClient.getInstance().create(ApiService::class.java)
            val response = apiService.getListData(currentLoadingPageKey)
            val responseData = mutableListOf<Data>()
            val data = response.body()?.data ?: emptyList()
            responseData.addAll(data)

            val prevKey = if (currentLoadingPageKey == 1) null else currentLoadingPageKey - 1

            return LoadResult.Page(
                data = responseData,
                prevKey = prevKey,
                nextKey = currentLoadingPageKey.plus(1)
            )

        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {
        return state.anchorPosition?.let { position ->
            state.closestPageToPosition(position)?.prevKey?.plus(
                1
            ) ?: state.closestPageToPosition(position)?.nextKey?.minus(1)
        }
    }
}
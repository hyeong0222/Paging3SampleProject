package com.example.paging3sampleproject.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paging3sampleproject.network.ApiService
import com.example.paging3sampleproject.network.RetrofitClient
import com.example.paging3sampleproject.model.User

class PostDataSource() : PagingSource<Int, User>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        try {
            val currentLoadingPageKey = params.key ?: 1
            val apiService = RetrofitClient.getInstance().create(ApiService::class.java)
            val response = apiService.getListData("tom", currentLoadingPageKey, 10)
            val data = response.body()?.users ?: emptyList()

            val prevKey = if (currentLoadingPageKey == 1) null else currentLoadingPageKey.minus(1)

            return LoadResult.Page(
                data = data,
                prevKey = prevKey,
                nextKey = currentLoadingPageKey.plus(1)
            )

        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return state.anchorPosition?.let { position ->
            state.closestPageToPosition(position)?.prevKey?.plus(
                1
            ) ?: state.closestPageToPosition(position)?.nextKey?.minus(1)
        }
    }
}
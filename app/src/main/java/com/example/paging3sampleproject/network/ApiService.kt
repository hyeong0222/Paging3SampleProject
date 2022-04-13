package com.example.paging3sampleproject.network

import com.example.paging3sampleproject.model.SearchUser
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search/users")
    suspend fun getListData(@Query("q") queryText: String, @Query("page") pageNumber: Int, @Query("per_page") perPage: Int): Response<SearchUser>
}
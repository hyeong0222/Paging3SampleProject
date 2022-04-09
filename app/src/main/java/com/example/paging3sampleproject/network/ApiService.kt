package com.example.paging3sampleproject.network

import com.example.paging3sampleproject.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/users")
    suspend fun getListData(@Query("page") pageNumber: Int): Response<ApiResponse>
}
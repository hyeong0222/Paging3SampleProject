package com.example.paging3sampleproject.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {
        private var INSTANCE: Retrofit? = null

        fun getInstance(): Retrofit = INSTANCE ?: synchronized(this) {
            INSTANCE ?: Retrofit.Builder().baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create()).build().also { INSTANCE = it }
        }
    }
}
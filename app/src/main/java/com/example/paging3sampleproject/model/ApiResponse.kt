package com.example.paging3sampleproject.model

data class ApiResponse(
    private val ad: Ad,
    val data: List<Data>,
    private val page: Int,
    private val per_page:Int,
    private val total: Int,
    private val total_pages: Int,
)
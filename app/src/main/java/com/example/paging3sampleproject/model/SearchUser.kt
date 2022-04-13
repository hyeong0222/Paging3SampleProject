package com.example.paging3sampleproject.model

import com.example.paging3sampleproject.model.User
import com.google.gson.annotations.SerializedName

data class SearchUser(
    @SerializedName("items")
    val users: List<User>? = null,
)
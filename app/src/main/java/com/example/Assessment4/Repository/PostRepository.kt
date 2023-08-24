package com.example.Assessment4.Repository

import com.example.Assessment4.Model.PostResponse
import com.example.Assessment4.api.ApiClient
import com.example.Assessment4.api.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class PostRepository {
    val apiClient=ApiClient.buildClient(ApiInterface::class.java)

    suspend fun getPost():Response<PostResponse>{
        return withContext(Dispatchers.IO){
            apiClient.getPost()}
    }
}
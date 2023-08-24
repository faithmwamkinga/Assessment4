package com.example.Assessment4.api

import com.example.Assessment4.Model.PostResponse
import com.example.Assessment4.Model.Post
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface `ApiInterface` {
    @GET("/product")
suspend fun getPost(): Response<PostResponse>      //call for gettiing a list of product

    @GET("/product/{id}")
    suspend fun getPostById(@Path("id")productId:Int):Response<Post>


    @POST("/product")
    fun postProduct ():Call<List<POST>>
}
package com.example.testapp.json

import com.example.testapp.UserData
import com.example.testapp.json.Paging.UserDatawithName
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface JSONAPI {
    @GET("posts")
    suspend fun getPhotos(): Response<Array<UserData>>

    @GET("posts/{id}/comments")
    suspend fun getPhotoswithId(@Path("id") id: Int): Response<Array<UserDatawithName>>

}
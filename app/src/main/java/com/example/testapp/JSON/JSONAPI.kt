package com.example.testapp.JSON

import retrofit2.Response
import retrofit2.http.GET

interface JSONAPI {
    @GET("posts")
    suspend fun getPhotos(): Response<Array<UserData>>

}
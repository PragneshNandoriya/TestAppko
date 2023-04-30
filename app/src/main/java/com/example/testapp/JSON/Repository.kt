package com.example.testapp.JSON

import retrofit2.Response
import retrofit2.Retrofit

class Repository {

    val retrofit: Retrofit = RetroClient.getRetrofit()

    suspend fun getPhotoData(): Response<Array<UserData>> {
        return retrofit.create(JSONAPI::class.java).getPhotos()
    }


}
package com.example.testapp.JSON

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetroClient {

    val baseURL = "https://jsonplaceholder.typicode.com/"
    var clientBuilder = OkHttpClient.Builder()
        .readTimeout(3, TimeUnit.MINUTES)
        .connectTimeout(3, TimeUnit.MINUTES)
        .writeTimeout(3, TimeUnit.MINUTES)
    var interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()


    fun getRetrofit(): Retrofit {
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient: OkHttpClient.Builder = OkHttpClient.Builder().addInterceptor(interceptor)

        return Retrofit.Builder().baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient.build())
            .build()
    }

}
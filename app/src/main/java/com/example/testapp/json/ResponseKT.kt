package com.example.testapp.json

sealed class ResponseKT<T>(val data: T? = null, val msg: String? = null) {


    class success<T>(data1: T) : ResponseKT<T>(data1)

    class Error<T>(message: String) : ResponseKT<T>(msg = message)

    class Loading<T> : ResponseKT<T>()
}
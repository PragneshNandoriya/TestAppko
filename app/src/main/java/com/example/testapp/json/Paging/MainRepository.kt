package com.example.testapp.json.Paging

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData

import com.example.testapp.json.JSONAPI

class MainRepositoryconstructor(private val retrofitService: JSONAPI) {

    fun getAllUserData(): LiveData<PagingData<UserDatawithName>> {

        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false,
                initialLoadSize = 2
            ),
            pagingSourceFactory = {
                UserPagingSource(retrofitService)
            }, initialKey = 1
        ).liveData
    }
}
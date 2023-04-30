package com.example.testapp.json

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.testapp.UserData
import com.example.testapp.json.Paging.MainRepositoryconstructor
import com.example.testapp.json.Paging.UserDatawithName
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {

    val jsonphotdata = MutableLiveData<Array<UserData>>()
    val userpagingData = MutableLiveData<Array<UserDatawithName>>()
    val repository = Repository()

    fun getAPIData() {
        Log.e("UserPhotoActivity", "getAPIData")
        viewModelScope.launch {
            val response = repository.getPhotoData()
            if (response.isSuccessful) {
                Log.e("ViewModel", "response:" + response.message())
                val data = ResponseKT.success(response.body())
                jsonphotdata.value = data.data!!
            } else {
                Log.e("ViewModel", "error response:" + response.errorBody().toString())
            }
        }
    }

    fun getUsersList(): LiveData<PagingData<UserDatawithName>> {
        return MainRepositoryconstructor(
            RetroClient.getRetrofit().create(JSONAPI::class.java)
        ).getAllUserData().cachedIn(viewModelScope)
    }
}
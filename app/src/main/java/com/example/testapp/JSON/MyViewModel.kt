package com.example.testapp.JSON

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {

    val jsonphotdata = MutableLiveData<Array<UserData>>()
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


}
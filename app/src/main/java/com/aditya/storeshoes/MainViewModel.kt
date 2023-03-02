package com.aditya.storeshoes

import android.provider.ContactsContract.DeletedContacts
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.DELETE

class MainViewModel : ViewModel() {
    private val _store = MutableLiveData<List<Store>>()
    val store: LiveData<List<Store>> = _store

    private val _inputSepatu = MutableLiveData<ServerResponse>()
    val inputSepatu: LiveData<ServerResponse> = _inputSepatu

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading


    init {
        getStore()
    }

     fun getStore() {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getStore()
        client.enqueue(object : retrofit2.Callback<List<Store>> {
            override fun onResponse(call: Call<List<Store>>, response: Response<List<Store>>) {
                if (response.isSuccessful) {
                    _isLoading.value = false
                    val responseBody = response.body()
                    if (responseBody != null) {
                        _store.value = responseBody
                    }
                }
            }

            override fun onFailure(call: Call<List<Store>>, t: Throwable) {
                _isLoading.value = false
                Log.d("Respons::::::::", t.message.toString())
            }
        })
    }

    fun inputSepatu(inputSepatu: InputSepatu) {
        _isLoading.value = true
        val client = ApiConfig.getApiService().inputShoes(inputSepatu)
        client.enqueue(object : retrofit2.Callback<ServerResponse> {
            override fun onResponse(
                call: Call<ServerResponse>,
                response: Response<ServerResponse>
            ) {
                if (response.isSuccessful) {
                    _isLoading.value = false
                    val responseBody = response.body()
                    if (responseBody != null) {
                        _inputSepatu.value = responseBody
                    }
                }
            }

            override fun onFailure(call: Call<ServerResponse>, t: Throwable) {
                _isLoading.value = false
                Log.d("Respons::::::::", t.message.toString())
            }
        })
    }
}


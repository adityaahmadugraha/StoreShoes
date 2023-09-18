package com.aditya.storeshoes

import androidx.lifecycle.LiveData
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("produk/api_tampil_all.php")
    fun getStore(): Call<List<Store>>

    @POST("produk/api_tambah.php")
    fun inputShoes(
        @Body input : InputSepatu
    ): Call<ServerResponse>


    @GET("produk/api_hapus.php")
    fun deleteShoes(
        @Query("id") id:String
    ): Call<ServerResponse>


    @POST("produk/api_edit.php")
    fun updateShoes(
        @Body update: UpdateSepatu
    ): Call<ServerResponse>


    @POST("produk/api_tampil_all.php")
    fun postStore(
    ): Call<List<Store>>


}


package com.aditya.storeshoes

import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("produk/api_tampil_all.php")
    fun getStore(): Call<List<Store>>

    @FormUrlEncoded
    @PUT("produk/api_tampil_all.php")
    fun putStore(
    ): Call<List<Store>>

    @FormUrlEncoded
    @POST("produk/api_tampil_all.php")
    fun postStore(
    ): Call<List<Store>>

    @FormUrlEncoded
    @DELETE("produk/api_tampil_all.php")
    fun deleteStore(
    ): Call<List<Store>>

}


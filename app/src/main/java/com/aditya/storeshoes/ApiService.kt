package com.aditya.storeshoes

import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("produk/api_tampil_all.php")
    fun getStore(): Call<List<Store>>

    @POST("produk/api_tambah.php")
    fun inputShoes(
        @Body input : InputSepatu
    ): Call<ServerResponse>

//    @FormUrlEncoded
//    @POST("produk/api_tampil_all.php")
//    fun inputShoes(
//        @Field("nama") nama: String,
//        @Field("nomor") nomor: Int,
//        @Field("warna") warna: String,
//        @Field("harga") harga: Int,
//        @Field("image") image: String,
//    ): Call<ServerResponse>


    @FormUrlEncoded
    @POST("produk/api_tampil_all.php")
    fun postStore(
    ): Call<List<Store>>


    @GET("produk/api_hapus.php")
    fun deleteShoes(
        @Query("id") id:String
    ): Call<ServerResponse>
}


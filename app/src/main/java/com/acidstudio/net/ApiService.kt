package com.acidstudio.net

import retrofit2.Call
import retrofit2.http.GET


interface ApiService {
    @GET("products")
    fun listProducts(): Call<ListProductResponse>

}
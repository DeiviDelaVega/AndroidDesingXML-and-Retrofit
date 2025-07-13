package com.acidstudio.net

import retrofit2.Call
import retrofit2.http.GET

interface ApiServiceUser {
    @GET("users")
    fun listUser(): Call<ListUserResponse>
}
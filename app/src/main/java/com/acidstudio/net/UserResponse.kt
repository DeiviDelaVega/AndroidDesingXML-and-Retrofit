package com.acidstudio.net

import com.google.gson.annotations.SerializedName

class UserResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("firstName")
    val nombre: String,
    @SerializedName("lastName")
    val apellido: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("university")
    val universidad: String

)
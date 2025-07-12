package com.acidstudio.net

import com.google.gson.annotations.SerializedName

class ProductResponse (
    @SerializedName("id")
    val id : Int,
    @SerializedName("title")
    val titulo : String,
    @SerializedName("price")
    val precio : Double,
    @SerializedName("thumbnail")
    val imagen : String
)
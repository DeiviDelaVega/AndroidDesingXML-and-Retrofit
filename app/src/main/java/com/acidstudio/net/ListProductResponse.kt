package com.acidstudio.net

import com.google.gson.annotations.SerializedName

class ListProductResponse(
    @SerializedName("products")
    val products: List<ProductResponse>,
)
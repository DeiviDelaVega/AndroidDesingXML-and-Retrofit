package com.acidstudio.net

import com.google.gson.annotations.SerializedName

class ListUserResponse (
    @SerializedName("users")
    val user : List<UserResponse>
)
package com.trianglz.task.usersmain.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserDataModel(
    @Json(name = "avatar")
    var avatar: String,
    @Json(name = "email")
    var email: String,
    @Json(name = "first_name")
    var firstName: String,
    @Json(name = "id")
    var id: Int,
    @Json(name = "last_name")
    var lastName: String
)
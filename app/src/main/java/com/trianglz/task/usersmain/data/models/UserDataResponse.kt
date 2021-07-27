package com.trianglz.task.usersmain.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserDataResponse(
    @Json(name = "data")
    var usersList: List<UserDataModel>,
    @Json(name = "page")
    var page: Int,
    @Json(name = "per_page")
    var perPage: Int,

    @Json(name = "total")
    var total: Int,
    @Json(name = "total_pages")
    var totalPages: Int
)
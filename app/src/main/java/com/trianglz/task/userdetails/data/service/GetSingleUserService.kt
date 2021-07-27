package com.trianglz.task.usersmain.data.service

import com.haroldadmin.cnradapter.NetworkResponse
import com.trianglz.task.common.utils.Constants
import com.trianglz.task.userdetails.data.models.response.UserResponseModel
import retrofit2.http.GET
import retrofit2.http.Path


interface GetSingleUserService {
    @GET(Constants.USER_PATH)
    suspend fun getUser(@Path("id") id: Int ): NetworkResponse<UserResponseModel, String>

}
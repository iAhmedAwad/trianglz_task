package com.trianglz.task.usersmain.data.service

import com.haroldadmin.cnradapter.NetworkResponse
import com.trianglz.task.common.utils.Constants
import com.trianglz.task.usersmain.data.models.UserDataModel
import retrofit2.http.GET
import retrofit2.http.Path


interface GetSingleUserService {
    @GET(Constants.USER_PATH)
    suspend fun getUser(@Path("id") id: Int ): NetworkResponse<UserDataModel, String>

}
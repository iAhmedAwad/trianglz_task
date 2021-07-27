package com.trianglz.task.usersmain.data.service

import com.haroldadmin.cnradapter.NetworkResponse
import com.trianglz.task.common.utils.Constants
import com.trianglz.task.usersmain.data.models.UserDataResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface GetUsersService {
    @GET(Constants.USERS_PATH)
    suspend fun getUsers(@Query(Constants.PAGE_NUMBER) pageNumber: Int = 1): NetworkResponse<UserDataResponse, String>

}
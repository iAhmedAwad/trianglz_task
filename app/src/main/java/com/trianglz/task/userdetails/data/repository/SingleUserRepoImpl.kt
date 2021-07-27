package com.trianglz.task.userdetails.data.repository

import com.haroldadmin.cnradapter.NetworkResponse
import com.trianglz.task.common.utils.ErrorChannel
import com.trianglz.task.userdetails.domain.repository.SingleUserRepo
import com.trianglz.task.usersmain.data.models.UserDataModel
import com.trianglz.task.usersmain.data.service.GetSingleUserService
import com.trianglz.task.usersmain.data.toUserDomainModel
import com.trianglz.task.usersmain.domain.models.UserDomainModel
import javax.inject.Inject

class SingleUserRepoImpl @Inject constructor(private val getSingleUserService: GetSingleUserService) : SingleUserRepo {

    override suspend fun getUser(id: Int): UserDomainModel? {

        val result: NetworkResponse<UserDataModel, String> = getSingleUserService.getUser(id)

        when (result) {
            is NetworkResponse.Success -> {
                return result.body.toUserDomainModel()
            }
            is NetworkResponse.NetworkError -> {
                ErrorChannel.emitErrors(result.error.message)
                return null
            }

            is NetworkResponse.ServerError -> {
                ErrorChannel.emitErrors(result.body)

                return null

            }
            is NetworkResponse.UnknownError -> {
                ErrorChannel.emitErrors(result.error.message)
                return null

            }
        }


    }
}


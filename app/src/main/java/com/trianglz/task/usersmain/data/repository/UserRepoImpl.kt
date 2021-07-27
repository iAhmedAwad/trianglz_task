package com.trianglz.task.usersmain.data.repository

import com.haroldadmin.cnradapter.NetworkResponse
import com.trianglz.task.common.utils.ErrorChannel
import com.trianglz.task.usersmain.data.models.UserDataResponse
import com.trianglz.task.usersmain.data.service.GetUsersService
import com.trianglz.task.usersmain.data.toUserDomainModel
import com.trianglz.task.usersmain.domain.models.UserDomainModel
import com.trianglz.task.usersmain.domain.repository.UsersRepo
import javax.inject.Inject

class UserRepoImpl @Inject constructor(private val getUsersService: GetUsersService) : UsersRepo {

    override suspend fun getUsers(pageNumber: Int): List<UserDomainModel> {

        val result: NetworkResponse<UserDataResponse, String> = getUsersService.getUsers()

        when (result) {
            is NetworkResponse.Success -> {
                return result.body.usersList.map { it.toUserDomainModel() }
            }
            is NetworkResponse.NetworkError -> {
                ErrorChannel.emitErrors(result.error.message)
                return emptyList()
            }

            is NetworkResponse.ServerError -> {
                ErrorChannel.emitErrors(result.body)

                return emptyList()

            }
            is NetworkResponse.UnknownError -> {
                ErrorChannel.emitErrors(result.error.message)
                return emptyList()

            }
        }


    }
}


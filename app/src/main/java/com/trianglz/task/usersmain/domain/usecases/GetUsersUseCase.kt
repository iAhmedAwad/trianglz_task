package com.trianglz.task.usersmain.domain.usecases

import com.trianglz.task.usersmain.domain.models.UserDomainModel
import com.trianglz.task.usersmain.domain.repository.UsersRepo
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val usersRepo: UsersRepo) {

    suspend fun getUsers(): List<UserDomainModel>{

        return usersRepo.getUsers()
    }

}
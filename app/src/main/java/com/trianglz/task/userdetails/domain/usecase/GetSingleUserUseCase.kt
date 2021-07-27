package com.trianglz.task.userdetails.domain.usecase

import com.trianglz.task.userdetails.domain.repository.SingleUserRepo
import com.trianglz.task.usersmain.domain.models.UserDomainModel
import javax.inject.Inject

class GetSingleUserUseCase @Inject constructor(private val singleUserRepo: SingleUserRepo) {

    suspend fun getUser(id: Int): UserDomainModel?{

        return singleUserRepo.getUser(id)
    }

}
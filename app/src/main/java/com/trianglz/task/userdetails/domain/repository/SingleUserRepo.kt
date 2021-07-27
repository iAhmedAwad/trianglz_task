package com.trianglz.task.userdetails.domain.repository

import com.trianglz.task.usersmain.domain.models.UserDomainModel

interface SingleUserRepo {
    suspend fun getUser(id: Int): UserDomainModel?
}
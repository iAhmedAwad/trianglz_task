package com.trianglz.task.usersmain.domain.repository

import com.trianglz.task.usersmain.domain.models.UserDomainModel

interface UsersRepo {
  suspend  fun getUsers(pageNumber: Int=1): List<UserDomainModel>
}
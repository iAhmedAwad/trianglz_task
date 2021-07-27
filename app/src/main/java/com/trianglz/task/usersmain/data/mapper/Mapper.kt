package com.trianglz.task.usersmain.data

import com.trianglz.task.usersmain.data.models.UserDataModel
import com.trianglz.task.usersmain.domain.models.UserDomainModel

fun UserDataModel.toUserDomainModel(): UserDomainModel{
    return UserDomainModel(firstName = this.firstName,
    lastName = this.lastName, email = this.email, imageUrl = this.avatar)
}
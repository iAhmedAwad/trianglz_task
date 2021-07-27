package com.trianglz.task.usersmain.domain.models

import com.trianglz.task.usersmain.presentation.models.BaseUserPresentationModel


data class UserDomainModel(var id: Int, var name: String?, var email:String?, var imageUrl:String?):
    BaseUserPresentationModel()
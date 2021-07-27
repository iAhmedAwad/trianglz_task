package com.trianglz.task.userdetails.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trianglz.task.userdetails.domain.usecase.GetSingleUserUseCase
import com.trianglz.task.usersmain.domain.models.UserDomainModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserDetailedViewModel @Inject constructor(  private val singleUserUseCase: GetSingleUserUseCase) :
    ViewModel() {
    var userId: Int?=null
    private val _detailedUser: MutableLiveData<UserDomainModel> = MutableLiveData()
    val detailedUser: LiveData<UserDomainModel>
        get() = _detailedUser

    fun getUser() {
        viewModelScope.launch {
            _detailedUser.postValue(userId?.let { singleUserUseCase.getUser(it) })
        }
    }

}
package com.trianglz.task.userdetails.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trianglz.task.userdetails.domain.usecase.GetSingleUserUseCase
import com.trianglz.task.usersmain.domain.models.UserDomainModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserDetailedViewModel @Inject constructor(private val userId: Int, private val singleUserUseCase: GetSingleUserUseCase) :
    ViewModel() {
    private val _usersList: MutableLiveData<UserDomainModel> = MutableLiveData()
    val usersList: LiveData<UserDomainModel>
        get() = _usersList

    init {
        getUsers()
    }

    fun getUsers() {
        viewModelScope.launch {
            _usersList.postValue(singleUserUseCase.getUser(userId))
        }
    }

}
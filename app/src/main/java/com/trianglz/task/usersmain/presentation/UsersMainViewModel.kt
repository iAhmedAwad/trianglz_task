package com.trianglz.task.usersmain.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trianglz.task.usersmain.domain.models.UserDomainModel
import com.trianglz.task.usersmain.domain.usecases.GetUsersUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class UsersMainViewModel @Inject constructor(usersUseCase: GetUsersUseCase) : ViewModel() {
    private val _usersList: MutableLiveData<List<UserDomainModel>> = MutableLiveData()
    val usersList: LiveData<List<UserDomainModel>>
        get() = _usersList

    init {
        getUsers(usersUseCase)
    }

    private fun getUsers(usersUseCase: GetUsersUseCase) {
        viewModelScope.launch {
            _usersList.postValue(usersUseCase.getUsers())
        }
    }

}



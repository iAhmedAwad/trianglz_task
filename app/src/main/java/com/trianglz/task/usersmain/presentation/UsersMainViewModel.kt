package com.trianglz.task.usersmain.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trianglz.task.usersmain.domain.models.UserDomainModel
import com.trianglz.task.usersmain.domain.usecases.GetUsersUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class UsersMainViewModel @Inject constructor(private val usersUseCase: GetUsersUseCase) :
    ViewModel() {
    private val _usersList: MutableLiveData<List<UserDomainModel>> = MutableLiveData()
    val usersList: LiveData<List<UserDomainModel>>
        get() = _usersList

    fun getUsers() {
        viewModelScope.launch {
            _usersList.postValue(emptyList())

            _usersList.postValue(usersUseCase.getUsers())
        }
    }

}



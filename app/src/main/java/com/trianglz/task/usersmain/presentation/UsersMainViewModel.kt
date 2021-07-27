package com.trianglz.task.usersmain.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trianglz.task.usersmain.domain.usecases.GetUsersUseCase
import com.trianglz.task.usersmain.presentation.models.BaseUserPresentationModel
import com.trianglz.task.usersmain.presentation.models.ShimmerUserPresentationModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class UsersMainViewModel @Inject constructor(private val usersUseCase: GetUsersUseCase) :
    ViewModel() {
    private val _usersList: MutableLiveData<List<BaseUserPresentationModel>> = MutableLiveData()
    val usersList: LiveData<List<BaseUserPresentationModel>>
        get() = _usersList


    init {
        getUsers()
    }

    fun getUsers() {
        viewModelScope.launch {
            _usersList.postValue(listOf(ShimmerUserPresentationModel(),ShimmerUserPresentationModel(),ShimmerUserPresentationModel()))

            _usersList.postValue(usersUseCase.getUsers())
        }
    }

}



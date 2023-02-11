package com.study.testforwork.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.study.testforwork.domain.model.UsersModel
import com.study.testforwork.domain.repository.UsersRepository
import com.study.testforwork.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val usersRepository: UsersRepository
): ViewModel() {

    private val _userState : MutableLiveData<Resource<UsersModel>> = MutableLiveData()
    val userState: LiveData<Resource<UsersModel>> = _userState

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData(true)
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        getUsersFromApi()
    }

    fun getUsersFromApi(){
        viewModelScope.launch {
            _isLoading.value = true
            _userState.value = usersRepository.fetchUsersRepository()
            _isLoading.value = false
        }
    }

}

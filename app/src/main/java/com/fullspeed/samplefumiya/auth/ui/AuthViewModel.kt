package com.fullspeed.samplefumiya.auth.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.fullspeed.samplefumiya.auth.AuthRepository
import com.fullspeed.samplefumiya.common.BaseViewModel
import com.fullspeed.samplefumiya.model.User
import kotlinx.coroutines.launch

class AuthViewModel(private val repository: AuthRepository):BaseViewModel() {

    private val _userData = MutableLiveData<User>()
    val userData:LiveData<User>
    get() = _userData

    fun login(){
        viewModelScope.launch {
            startLoading()
            Thread.sleep(10000)
            var user = repository.login()
            stopLoading()
            _userData.postValue(user)
        }
    }




}
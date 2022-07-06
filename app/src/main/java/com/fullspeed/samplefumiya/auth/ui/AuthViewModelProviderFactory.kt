package com.fullspeed.samplefumiya.auth.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fullspeed.samplefumiya.auth.AuthRepository
import javax.inject.Inject

class AuthViewModelProviderFactory @Inject constructor(private val repository: AuthRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AuthViewModel(repository) as T
    }
}
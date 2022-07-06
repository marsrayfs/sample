package com.fullspeed.samplefumiya

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.fullspeed.samplefumiya.auth.ui.AuthViewModel
import com.fullspeed.samplefumiya.auth.ui.AuthViewModelProviderFactory

import com.fullspeed.samplefumiya.common.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity:BaseActivity() {

    @Inject
    lateinit var viewModelFactory: AuthViewModelProviderFactory
    lateinit var authViewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        authViewModel = ViewModelProvider(this,viewModelFactory).get(AuthViewModel::class.java)
        authViewModel.userData.observe(this,{
            Log.d("LOGIN","login:"+it.username)
        })

        authViewModel.login()

    }

}
package com.fullspeed.samplefumiya.auth

import com.fullspeed.samplefumiya.model.User
import javax.inject.Inject

class AuthService @Inject constructor(var api:AuthApi) {

    suspend fun login(): User{
        return api.login()
    }


}
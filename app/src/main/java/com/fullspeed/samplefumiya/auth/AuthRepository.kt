package com.fullspeed.samplefumiya.auth

import com.fullspeed.samplefumiya.model.User
import javax.inject.Inject

class AuthRepository @Inject constructor(var service:AuthService) {

    suspend fun login(): User {
        return service.login()
    }

}
package com.fullspeed.samplefumiya.auth

import com.fullspeed.samplefumiya.model.User
import retrofit2.http.GET

interface AuthApi {

    @GET("login")
    suspend fun login():User

}
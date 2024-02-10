package com.example.apiproject.service

import com.example.apiproject.classes.UserInfo
import retrofit2.http.GET

interface UserInfoService {
    @GET("reverse-geocode-client")
    suspend fun getUserInfo(): UserInfo
}


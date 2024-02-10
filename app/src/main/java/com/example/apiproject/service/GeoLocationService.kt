package com.example.apiproject.service

import com.example.apiproject.classes.GeoLocationResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GeoLocationService {
    @GET("ipgeo")
    suspend fun getGeoLocation(@Query("apiKey") apiKey: String): GeoLocationResponse
}
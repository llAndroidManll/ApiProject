package com.example.apiproject.service

import com.example.apiproject.model.ExchangeRateResponse
import retrofit2.http.GET

interface ExchangeRateService {
    @GET("latest/USD")
    suspend fun getExchangeRate(): ExchangeRateResponse
}
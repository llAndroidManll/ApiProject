package com.example.apiproject.service

import com.example.apiproject.model.ConversationResponse
import com.example.apiproject.model.ExchangeRateResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ConversationService {

    @GET("pair/{baseCurrency}/{targetCurrency}/{amount}")
    suspend fun getConversationResponse(
        @Path("baseCurrency") baseCurrency: String,
        @Path("targetCurrency") targetCurrency: String,
        @Path("amount") amount: Double
    ): ConversationResponse
}
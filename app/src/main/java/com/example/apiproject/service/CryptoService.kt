package com.example.apiproject.service

import com.example.apiproject.classes.Crypto
import com.example.apiproject.classes.CryptoResponse
import retrofit2.http.GET


interface CryptoService {
    @GET("markets?vs_currency=usd&order=market_cap_desc&per_page=100&page=1&sparkline=false")
    suspend fun getCrypto(): List<Crypto>
}

package com.example.apiproject.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val GEOLOCATION_BASE_URL = "https://api.ipgeolocation.io/"
    private const val CRYPTO_BASE_URL = "https://api.coingecko.com/api/v3/coins/"
    private const val EXCHANGERATE_BASE_URL = "https://v6.exchangerate-api.com/v6/3c4a7f9071a1c7b7f28fedc9/"

    private val geoLocationRetrofit = Retrofit.Builder()
        .baseUrl(GEOLOCATION_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    private val cryptoRetrofit = Retrofit.Builder()
        .baseUrl(CRYPTO_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val exchangeRetrofit = Retrofit.Builder()
        .baseUrl(EXCHANGERATE_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val conversationRetrofit = Retrofit.Builder()
        .baseUrl(EXCHANGERATE_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val geoLocationService: GeoLocationService = geoLocationRetrofit.create(GeoLocationService::class.java)
    val cryptoService: CryptoService = cryptoRetrofit.create(CryptoService::class.java)
    val exchangeService: ExchangeRateService = exchangeRetrofit.create(ExchangeRateService::class.java)
    val conversationService: ConversationService = conversationRetrofit.create(ConversationService::class.java)
}
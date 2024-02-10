package com.example.apiproject.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val GEOLOCATION_BASE_URL = "https://api.ipgeolocation.io/"
    private const val USERINFO_BASE_URL = "https://api.bigdatacloud.net/data/"
    private const val CRYPTO_BASE_URL = "https://api.coingecko.com/api/v3/coins/"

    private val geoLocationRetrofit = Retrofit.Builder()
        .baseUrl(GEOLOCATION_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val userInfoRetrofit = Retrofit.Builder()
        .baseUrl(USERINFO_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val cryptoRetrofit = Retrofit.Builder()
        .baseUrl(CRYPTO_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val geoLocationService: GeoLocationService = geoLocationRetrofit.create(GeoLocationService::class.java)
    val userInfoService: UserInfoService = userInfoRetrofit.create(UserInfoService::class.java)
    val cryptoService: CryptoService = cryptoRetrofit.create(CryptoService::class.java)
}